package com.provigil.calculator.helper;

import java.util.ArrayList;
import java.util.List;

import com.provigil.calculator.dto.Output;
import com.provigil.calculator.dto.Result;
import com.provigil.calculator.dto.Subscription;
import com.provigil.calculator.dto.Subscriptions;

public class CostCalculatorHelper {
	
	public  Result caluclateCost(Subscriptions list) {
		Result result = new Result();
		try {
			List<Output> outputList = new ArrayList<>();
			for (Subscription sub : list.getSubscription()) {
				Output output = new Output();
				Integer cost = 0;
				if (sub.getPlan().equalsIgnoreCase("MONTHLY")) {
					if (sub.getLocation().equalsIgnoreCase("INDOOR")) {
						cost = calucateMonthlyIndoor(sub);
					} else if (sub.getLocation().equalsIgnoreCase("OUTDOOR")) {
						cost = calucateMonthlyOutdoor(sub);
					}
				} else if (sub.getPlan().equalsIgnoreCase("YEARLY")) {
					if (sub.getLocation().equalsIgnoreCase("INDOOR")) {
						cost = calucateYearlyIndoor(sub);
					} else if (sub.getLocation().equalsIgnoreCase("OUTDOOR")) {
						cost = calucateYearlyOutdoor(sub);

					}
				}
				output.setId(sub.getId());
				output.setCost(cost);
				outputList.add(output);
			}
			result.setOutputList(outputList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;

	}

	private static Integer calucateMonthlyIndoor(Subscription request) {
		Integer sum = 0;
		if (request.getArea() > 0 && request.getArea() <= 2500) {
			sum = request.getArea() * 2;
		} else if (request.getArea() > 2501 && request.getArea() < 5000) {
			sum = (int) ((2500 * 2) + ((request.getArea() - 2500) * 1.5));
		} else if (request.getArea() >= 5001 && request.getArea() < 50000) {
			sum = (int) ((2500 * 2) + (2500 * 1.5) + ((request.getArea() - (2500 + 2500)) * 1));
		} else if (request.getArea() >= 50001) {

			sum = (int) (((2500 * 2) + (2500 * 1.5) + (45000 * 1))
					+ ((request.getArea() - (2500 + 2500 + 45000)) * 0.8));
		}
		return sum;
	}

	private static Integer calucateMonthlyOutdoor(Subscription request) {
		Integer sum = 0;
		if (request.getArea() > 0 && request.getArea() <= 2500) {
			sum = (int) ((int) request.getArea() * 2.5);
		} else if (request.getArea() > 2501 && request.getArea() < 5000) {
			sum = (int) (2500 * 2.5 + ((request.getArea() - 2500) * 1.5));
		} else if (request.getArea() >= 5001 && request.getArea() < 50000) {
			sum = (int) ((2500 * 2.5) + (2500 * 1.5) + ((request.getArea() - (2500 + 2500)) * 1.2));
		} else if (request.getArea() >= 50001) {
			sum = (int) (((2500 * 2.5) + (2500 * 1.5) + (45000 * 1.2))
					+ ((request.getArea() - (2500 + 2500 + 45000)) * 0.8));
		}
		return sum;
	}

	private static Integer calucateYearlyIndoor(Subscription request) {
		Integer sum = 0;
		if (request.getArea() > 0 && request.getArea() <= 2500) {
			sum = (int) (request.getArea() * 1.5);
		} else if (request.getArea() > 2501 && request.getArea() < 5000) {
			sum = (int) (2500 * 1.5 + ((request.getArea() - 2500) * 1));
		} else if (request.getArea() >= 5001 && request.getArea() < 50000) {
			sum = (int) ((2500 * 1.5) + (2500 * 1) + ((request.getArea() - (2500 + 2500)) * 0.6));
		} else if (request.getArea() >= 50001) {
			sum = (int) (((2500 * 1.5) + (2500 * 1) + (45000 * 0.6))
					+ ((request.getArea() - (2500 + 2500 + 45000)) * 0.5));
		}
		return sum;
	}

	private static Integer calucateYearlyOutdoor(Subscription request) {
		Integer sum = 0;
		if (request.getArea() > 0 && request.getArea() <= 2500) {
			sum = (int) ((int) request.getArea() * 2); 
		} else if (request.getArea() > 2501 && request.getArea() < 5000) {
			sum = (int) (2500 * 2 + ((request.getArea() - 2500) * 1));
		} else if (request.getArea() >= 5001 && request.getArea() < 50000) {
			sum = (int) ((2500 * 2) + (2500 * 1) + ((request.getArea() - (2500 + 2500)) * 0.8));
		} else if (request.getArea() >= 50001) {
			sum = (int) (((2500 * 2) + (2500 * 1) + (45000 * 0.8))
					+ ((request.getArea() - (2500 + 2500 + 45000)) * 0.5));
		}
		return sum;
	}


}
