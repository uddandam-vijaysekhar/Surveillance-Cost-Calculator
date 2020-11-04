package com.provigil.calculator.dto;

public class Output {

	private Integer id;
	private Integer cost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", cost=" + cost + "]";
	}

}
