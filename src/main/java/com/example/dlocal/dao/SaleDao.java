package com.example.dlocal.dao;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dlocal.dto.StatusAmountKeyValue;
import com.example.dlocal.model.Sale;

/*
 * List of Sale related dao method available for use.
 * 
 */
@Repository
public interface SaleDao extends JpaRepository<Sale, Integer> {

	@Query(value = "select id from sale where merchant_id=?1 and transaction_id=?2", nativeQuery = true)
	public Integer findSaleByMerchantAndTransactionId(Integer merchanyId,
			long transactionId);

	@Query(value = "select new com.example.dlocal.dto.StatusAmountKeyValue(status,sum(amount)) From Sale where merchant_id=?1 AND creation_date >=?2 AND creation_date <=?3 GROUP BY status", nativeQuery = false)
	public Collection<StatusAmountKeyValue> getAmountByStatusAndDates(
			Integer merchantId, Date from, Date to);
}
