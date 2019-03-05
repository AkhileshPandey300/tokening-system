package com.pramati.bank.tokening.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.bank.tokening.system.repository.ServiceRepository;

/**
 * @author akhileshp
 *
 */
@Service
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	private ServiceRepository serviceRepository;

	public void setServiceRepository(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	@Override
	@Transactional
	public com.pramati.bank.tokening.system.model.Service createService(
			com.pramati.bank.tokening.system.model.Service service) {

		return this.serviceRepository.save(service);
	}

}
