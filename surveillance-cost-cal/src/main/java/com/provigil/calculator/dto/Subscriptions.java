package com.provigil.calculator.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subscriptions")
@XmlAccessorType (XmlAccessType.FIELD)
public class Subscriptions {

	@XmlElement(name = "subscription")
	private List<Subscription> subscription;

	public List<Subscription> getSubscription() {
		return subscription;
	}

	public void setSubscription(List<Subscription> subscription) {
		this.subscription = subscription;
	}

}
