/**
 * 
 */
package com.pramati.bank.tokening.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.bank.tokening.system.exception.CustomerNotFoundException;
import com.pramati.bank.tokening.system.model.Customer;

/**
 * @author akhileshp
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByMobile(String mobile) throws CustomerNotFoundException;

}
