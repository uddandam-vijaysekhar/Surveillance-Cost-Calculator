package com.provigil.calculator;

import com.provigil.calculator.dto.Result;
import com.provigil.calculator.dto.Subscriptions;
import com.provigil.calculator.helper.CostCalculatorHelper;
import com.provigil.calculator.xmlparser.XMLParser;

/**
 * Hello world!
 * 
 */
public class SurveillanceCostCal {

	public static void main(String[] args) {
		try {
			XMLParser parser = new XMLParser();
			Subscriptions subscriptions = parser.parseXML();
			if (null != subscriptions) {
				CostCalculatorHelper helper = new CostCalculatorHelper();
				Result result = helper.caluclateCost(subscriptions);
				parser.creatXMl(result);
			}
 
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
