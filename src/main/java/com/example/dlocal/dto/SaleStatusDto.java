package com.example.dlocal.dto;


public class SaleStatusDto {

	private Integer id;

	private String dateOfSale;

	private Integer merchantId;

	private Long transactionId;

	private Short status;

	public SaleStatusDto(Integer id, String dateOfSale, Integer merchantId,
			Long transactionId, Short status) {
		this.id = id;
		this.dateOfSale = dateOfSale;
		this.merchantId = merchantId;
		this.transactionId = transactionId;
		this.status = status;
	}

	public SaleStatusDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
}
