package com.example.dlocal.services;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dlocal.businessExceptions.ModelNotFoundException;
import com.example.dlocal.businessExceptions.NotPositiveAmountException;
import com.example.dlocal.businessExceptions.WrongBusinessLogicException;
import com.example.dlocal.currencyConverter.CurrencyServicesImpl;
import com.example.dlocal.dao.MerchantDao;
import com.example.dlocal.dao.SaleDao;
import com.example.dlocal.dto.BalanceDto;
import com.example.dlocal.dto.SaleDto;
import com.example.dlocal.dto.SaleStatusDto;
import com.example.dlocal.dto.StatusAmountKeyValue;
import com.example.dlocal.model.Sale;
import com.example.dlocal.servicesInterfaces.SaleServices;

@Component
public class SaleServicesImpl implements SaleServices {

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	SaleDao saleDao;

	@Autowired
	MerchantServicesImpl merchantServices;

	@Autowired
	CurrencyServicesImpl currencyServices;

	//
	// private final static Date FROM_DATE = new Date();
	//
	// private final static Date TO_DATE = new Date("3000-01-01");
	@Override
	public int create(@Valid @RequestBody SaleDto saleDto) {

		if (!merchantDao.existsById(saleDto.getMerchantId())) {
			throw new ModelNotFoundException("Merchant", "id",
					saleDto.getMerchantId());
		} else if (saleDto.getAmount() <= 0) {
			throw new NotPositiveAmountException();
		}

		// check if the (MerchantId,TransactionId) pair is already exists.
		Integer id = getSaleId(saleDto.getMerchantId(),
				saleDto.getTransactionId());
		if (id != null) {
			return id;
		}

		Sale sale = new Sale(currencyServices.getAmountInUsd(
				saleDto.getCurrency(), saleDto.getAmount()),
				saleDto.getMerchantId(), saleDto.getTransactionId(), new Date());

		// set pending status (1)
		sale.setStatus(Short.valueOf((short) 1));

		return saleDao.save(sale).getId();

	}

	@Override
	public SaleStatusDto getSaleById(@PathVariable(value = "id") Integer id) {

		if (id != null) {
			if (saleDao.findById(id).isPresent()) {
				Sale sale = saleDao.findById(id).get();
				return new SaleStatusDto(id, sale.getCreationDate().toString(),
						sale.getMerchantId(), sale.getTransactionId(),
						sale.getStatus());
			}
		}
		throw new WrongBusinessLogicException(
				"The given Sale id doesn't exists");
	}

	@Override
	public BalanceDto getBalance(
			@PathVariable(value = "id") Integer merchantId, Date from, Date to) {

		// check if exist merchant
		if (merchantDao.existsById(merchantId)) {

			BalanceDto balanceDto = new BalanceDto();

			Collection<StatusAmountKeyValue> keyVal = saleDao
					.getAmountByStatusAndDates(merchantId, from, to);

			for (StatusAmountKeyValue item : keyVal) {
				if (item.getStatus() == 1) {
					balanceDto.setTotalPending(item.getAmount());
				} else if (item.getStatus() == 2) {
					balanceDto.setTotalPaid(item.getAmount());
				} else if (item.getStatus() == 3) {
					balanceDto.setTotalRejected(item.getAmount());
				}
			}
			return balanceDto;
		}
		throw new ModelNotFoundException("Merchant", "id", merchantId);
	}

	private Integer getSaleId(Integer merchantId, Long transactionId) {
		if (transactionId != null) {
			return saleDao.findSaleByMerchantAndTransactionId(merchantId,
					transactionId);
		}
		return null;
	}
}
