package com.provigil.calculator.xmlparser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.provigil.calculator.dto.Result;
import com.provigil.calculator.dto.Subscriptions;

public class XMLParser {

	public Subscriptions parseXML() {
		File xmlFile = new File("C:\\Users\\vijay\\Desktop\\sample.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Subscriptions.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Subscriptions sublist = (Subscriptions) jaxbUnmarshaller.unmarshal(xmlFile);
			return sublist;
		} catch (JAXBException e) {
			e.printStackTrace();
		} 
		return null;
	}

	public void creatXMl(Result result) {

		try {
			File xmlFile = new File("C:\\Users\\vijay\\Desktop\\output.xml");
			JAXBContext context = JAXBContext.newInstance(Result.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(result, xmlFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
