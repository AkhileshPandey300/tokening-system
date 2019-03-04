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

	@Query("SELECT t.tokenNo FROM Tokens t where t.counterId = :counterId "
			+ "and date_format(date(created_at),'%Y-%m-%d') = date_format(now(),'%Y-%m-%d') and status = 'OPEN'")
	public Stream<Tokens> findByCounterId(long counterId);

}
