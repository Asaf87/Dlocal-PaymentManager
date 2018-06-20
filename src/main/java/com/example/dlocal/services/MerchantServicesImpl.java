package com.example.dlocal.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dlocal.dao.MerchantDao;
import com.example.dlocal.model.Merchant;
import com.example.dlocal.servicesInterfaces.MerchantServices;

@Service("merchantServices")
public class MerchantServicesImpl implements MerchantServices {

	@Autowired
	MerchantDao merchantDao;

	@Override
	public ResponseEntity<?> isExistMerchant(
			@PathVariable(value = "id") Integer merchantId) {
		HttpHeaders headers = new HttpHeaders();
		if (merchantDao.existsById(merchantId)) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		}
		return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
	}

	@Override
	public Merchant saveMerchant(@Valid @RequestBody Merchant merchant) {
		return merchantDao.save(merchant);
	}
}
