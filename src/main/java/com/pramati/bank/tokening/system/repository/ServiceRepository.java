package com.pramati.bank.tokening.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.bank.tokening.system.model.Service;

/**
 * @author akhileshp
 *
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

}
