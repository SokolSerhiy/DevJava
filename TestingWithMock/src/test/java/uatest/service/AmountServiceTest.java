package uatest.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.dto.form.AmountForm;
import ua.entity.Amount;
import ua.repository.AmountRepository;
import ua.service.implementation.AmountServiceImpl;

public class AmountServiceTest {

	AmountRepository amountRepository = mock(AmountRepository.class);
	
	AmountServiceImpl amountServiceImpl;
	
	@Before
	public void before(){
		Amount amount = new Amount();
		amount.setId(1L);
		when(amountRepository.findOne(1L)).thenReturn(amount);
		List<Amount> list = new ArrayList<>();
		list.add(amount);
		list.add(new Amount());
		when(amountRepository.findAll()).thenReturn(list);
		amountServiceImpl = new AmountServiceImpl(amountRepository);
	}
	
	@Test
	public void test1(){
		Amount one = amountServiceImpl.findOne(1L);
		Assert.assertEquals(new Long(1L), one.getId());
	}
	
	@Test
	public void test2(){
		List<Amount> list = amountServiceImpl.findAll();
		Assert.assertEquals(2, list.size());
	}
	
	@Test
	public void test3(){
		AmountForm form = new AmountForm();
		form.setAmount("3.5");
		amountServiceImpl.save(form);
		Assert.assertTrue(true);
	}
}
