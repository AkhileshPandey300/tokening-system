package com.pramati.bank.tokening.system.repository;

import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pramati.bank.tokening.system.model.Tokens;

/**
 * @author akhileshp
 *
 */
@Repository
public interface TokenRepository extends JpaRepository<Tokens, Long> {

	@Query("SELECT tok.tokenNo FROM Tokens tok INNER JOIN Customer cust ON tok.customerId = cust.id where tok.counterId = :counterId "
			+ "and date_format(date(tok.createdAt),'%Y-%m-%d') = date_format(now(),'%Y-%m-%d') "
			+ "and tok.status = 'OPEN' ORDER BY cust.customerType ASC , tok.id ASC")
	public Stream<Tokens> findByCounterId(long counterId);

}
