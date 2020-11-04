package com.provigil.calculator.helper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.provigil.calculator.dto.Output;
import com.provigil.calculator.dto.Result;
import com.provigil.calculator.dto.Subscription;
import com.provigil.calculator.dto.Subscriptions;

@RunWith(MockitoJUnitRunner.class)
public class CostCaluclatorHelperTest {
	
	@InjectMocks
	CostCalculatorHelper costCalculatorHelper;
	
	Result result = new Result();
	Subscriptions subscriptions = new Subscriptions();
	@Before
	public void setUp() {
		List<Subscription> subscriptionList = new ArrayList<>();
		Subscription sub1 = new Subscription();
		sub1.setId(1);
		sub1.setPlan("MONTHLY");
		sub1.setArea(25000);
		sub1.setLocation("Outdoor");
		subscriptionList.add(sub1);
		Subscription sub3 = new Subscription();
		sub3.setId(1);
		sub3.setPlan("MONTHLY");
		sub3.setArea(25000);
		sub3.setLocation("Indoor");
		subscriptionList.add(sub3);
		Subscription sub2 = new Subscription();
		sub2.setId(2);
		sub2.setPlan("YEARLY");
		sub2.setArea(25000);
		sub2.setLocation("Indoor");
		subscriptionList.add(sub2);
		Subscription sub4 = new Subscription();
		sub4.setId(2);
		sub4.setPlan("YEARLY");
		sub4.setArea(25000);
		sub4.setLocation("Outdoor");
		subscriptionList.add(sub4);
		subscriptions.setSubscription(subscriptionList);
		
		List<Output> outputList = new ArrayList<>();
		Output outPut1 = new Output();
		outPut1.setId(1);
		outPut1.setCost(32100);
		outputList.add(outPut1);
		Output outPut2 = new Output();
		outPut2.setId(2);
		outPut2.setCost(26100);
		Output outPut3 = new Output();
		outPut2.setId(3);
		outPut2.setCost(9100);
		outputList.add(outPut3);
		Output outPut4 = new Output();
		outPut4.setId(4);
		outPut4.setCost(5500);
		result.setOutputList(outputList);
		
	}
	
	@Test
	public void caluclateCostTest() {
		Result res = costCalculatorHelper.caluclateCost(subscriptions);
		assertEquals(res.getOutputList().get(0).getId(), result.getOutputList().get(0).getId());
	}

}
