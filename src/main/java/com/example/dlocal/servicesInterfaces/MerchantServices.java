package com.example.dlocal.servicesInterfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dlocal.model.Merchant;

@RestController
@RequestMapping("/merchantServices")
public interface MerchantServices {

	/**
	 * Check if Merchant exists
	 */
	@GetMapping("/isExist/{id}")
	ResponseEntity<?> isExistMerchant(Integer merchantId);

	/**
	 * Create a Merchant
	 */
	@PostMapping("/saveMerchant")
	Merchant saveMerchant(Merchant merchant);

}
