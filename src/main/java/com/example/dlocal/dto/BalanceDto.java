package com.example.dlocal.dto;

public class BalanceDto {

	private Double totalPaid = (double) 0;

	private Double totalPending = (double) 0;

	private Double totalRejected = (double) 0;

	public Double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public Double getTotalPending() {
		return totalPending;
	}

	public void setTotalPending(Double totalPending) {
		this.totalPending = totalPending;
	}

	public Double getTotalRejected() {
		return totalRejected;
	}

	public void setTotalRejected(Double totalRejected) {
		this.totalRejected = totalRejected;
	}

}
