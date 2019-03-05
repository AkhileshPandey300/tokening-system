/**
 * 
 */
package com.pramati.bank.tokening.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pramati.bank.tokening.system.exception.CounterNotFoundException;
import com.pramati.bank.tokening.system.model.Counter;

/**
 * @author akhileshp
 *
 */
@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
	
	@Query("select c from Counter c join c.services  ser where ser.id = :serviceId order by c.id ASC")
	public Counter findCounterByServiceId(long serviceId) throws CounterNotFoundException;

	
	@Query("select c from Counter c join c.services  ser where ser.id = :serviceId and c.id > :counterId")
	public List<Counter> findMultiCounterByServiceId(long serviceId,long counterId) throws CounterNotFoundException;
}
