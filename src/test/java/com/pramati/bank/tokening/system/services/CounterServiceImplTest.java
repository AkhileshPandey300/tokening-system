package com.pramati.bank.tokening.system.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.pramati.bank.tokening.system.exception.CounterNotFoundException;
import com.pramati.bank.tokening.system.model.Counter;
import com.pramati.bank.tokening.system.repository.CounterRepository;
import com.pramati.bank.tokening.system.utils.CustomerType;

class CounterServiceImplTest {

	@InjectMocks
	CounterServiceImpl counterServiceImpl;
	@Mock
	CounterRepository counterRepository;
	Counter counter;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		counter = new Counter();
		counter.setId(1);
		counter.setServiceId(1);
		counter.setType(CustomerType.PREMIUM.toString());
		counter.setAvailable(true);
	}

	@Test
	void testUpdateCounter() {
		when(counterRepository.save(counter)).thenReturn(counter);
		Assertions.assertThrows(CounterNotFoundException.class,

				() -> {
					counterServiceImpl.updateCounter(counter);
				});
		Counter resultAccount;
		try {
			resultAccount = counterServiceImpl.updateCounter(counter);

			assertNotNull(resultAccount);
			assertEquals(counter.getId(), resultAccount.getId());
			assertEquals(counter.getServiceId(), resultAccount.getServiceId());
		} catch (CounterNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testGetCounters() {
		List<Counter> listOfAccounts = new ArrayList<>();
		listOfAccounts.add(counter);
		when(counterRepository.findAll()).thenReturn(listOfAccounts);
		List<Counter> listResult = counterServiceImpl.getCounters();
		if (listResult != null) {
			assertEquals(counter.getId(), listResult.get(0).getId());
		}

	}

}
