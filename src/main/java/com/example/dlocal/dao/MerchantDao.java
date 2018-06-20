package com.example.dlocal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dlocal.model.Merchant;

/*
 * List of Merchant related dao methods available for use.
 * 
 */
@Repository
public interface MerchantDao extends JpaRepository<Merchant, Integer> {

}
