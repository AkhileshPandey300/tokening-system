/**
 * 
 */
package com.pramati.bank.tokening.system.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pramati.bank.tokening.system.model.Service;
import com.pramati.bank.tokening.system.services.ServicesService;

/**
 * @author pramati
 *
 */
@RestController
public class ServiceController {

	@Autowired
	private ServicesService servicesService;

	public void setServicesService(ServicesService servicesService) {
		this.servicesService = servicesService;
	}

	@PostMapping("/services")
	public Service createService(@Valid @RequestBody Service service) {
		return this.servicesService.createService(service);

	}

}
