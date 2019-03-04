/**
 * 
 */
package com.pramati.bank.tokening.system.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.bank.tokening.system.exception.CounterNotFoundException;
import com.pramati.bank.tokening.system.model.Counter;
import com.pramati.bank.tokening.system.repository.CounterRepository;

/**
 * @author akhileshp
 *
 */
@Service
public class CounterServiceImpl implements CounterService {

	private CounterRepository counterRepository;

	public void setCounterRepository(CounterRepository counterRepository) {
		this.counterRepository = counterRepository;
	}

	@Override
	@Transactional
	public Counter updateCounter(Counter counter) {
		counterRepository.findById(counter.getId())
				.orElseThrow(() -> new CounterNotFoundException("Counter Not Found"));
		return counterRepository.save(counter);
	}

	@Override
	@Transactional
	public List<Counter> getCounters() {
		return counterRepository.findAll();
	}

}
