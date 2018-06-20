package com.example.dlocal.servicesInterfaces;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dlocal.dto.BalanceDto;
import com.example.dlocal.dto.SaleDto;
import com.example.dlocal.dto.SaleStatusDto;

@RestController
@RequestMapping("/saleServices")
public interface SaleServices {

	/**
	 * Create a sale
	 * 
	 * @param saleDto
	 * @return the Id of the created sale
	 */
	@PostMapping("/create")
	int create(SaleDto saleDto);

	/**
	 * Get status of a Sale
	 * 
	 * @param id
	 * @return Dto contain details about the sale
	 */
	@GetMapping("/{id}")
	SaleStatusDto getSaleById(Integer id);

	/**
	 * Get the balance of Merchant Id with the given range of dates. 
	 * @param merchantId
	 * @param from - from the given date
	 * @param to - to the given date
	 * @return
	 */
	@GetMapping("/getBalanceByMerchant/{id}")
	BalanceDto getBalance(
			Integer merchantId,
			@RequestParam(value = "from") @DateTimeFormat(pattern = "yyyy-mm-dd") Date from,
			@RequestParam(value = "to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to);

}
