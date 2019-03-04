/**
 * 
 */
package com.pramati.bank.tokening.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.bank.tokening.system.exception.CounterNotFoundException;
import com.pramati.bank.tokening.system.model.Counter;
import com.pramati.bank.tokening.system.services.CounterService;

/**
 * @author pramati
 *
 */
@RestController
@RequestMapping("/counters")
public class CounterController {

	@Autowired
	private CounterService counterService;

	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}

	@PutMapping
	public Counter update(@Valid @RequestBody Counter counter) throws CounterNotFoundException {
		return counterService.updateCounter(counter);
	}

	@GetMapping
	public List<Counter> getCounters() {
		return counterService.getCounters();

	}

}
