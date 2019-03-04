/**
 * 
 */
package com.pramati.bank.tokening.system.services;

import java.util.List;

import com.pramati.bank.tokening.system.exception.CounterNotFoundException;
import com.pramati.bank.tokening.system.model.Counter;

/**
 * @author akhileshp
 *
 */
public interface CounterService {

	public Counter updateCounter(Counter counter) throws CounterNotFoundException;

	public List<Counter> getCounters();
}
