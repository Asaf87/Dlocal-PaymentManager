package com.example.dlocal.dto;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(
	name = "getAmountByStatusAndDates",
	query = "select status,sum(amount) from sale where merchant_id=:merchantId AND creation_date >= :fromDate AND creation_date <= :doDate GROUP BY status"
	)
})
public class StatusAmountKeyValue
{

	/**
	 * The status of the Sale. 10- pending, 20-paid, 30- rejected.
	 */
	private Short status;
	
	/**
	 * The total amount of sales for the status.
	 */
	private Double amount;
	

	public StatusAmountKeyValue(Short status, Double amount) {
		super();
		this.status = status;
		this.amount = amount;
	}
	
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
