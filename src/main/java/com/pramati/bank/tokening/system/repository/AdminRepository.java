package com.pramati.bank.tokening.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.bank.tokening.system.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
