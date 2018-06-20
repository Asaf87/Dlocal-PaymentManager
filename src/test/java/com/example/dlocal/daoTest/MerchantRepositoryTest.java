package com.example.dlocal.daoTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dlocal.dao.MerchantDao;
import com.example.dlocal.model.Merchant;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MerchantRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private MerchantDao merchantDao;

	@Test
	public void whenFindByName_thenReturnEmployee() {
		// given
		Merchant merchant = new Merchant();
		merchant.setName("Asaf");
		entityManager.persist(merchant);
		entityManager.flush();

		// when
		boolean found = merchantDao.existsById(merchant.getId());

		// then
		assertTrue(found);
	}
}
