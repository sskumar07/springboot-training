package com.kumar.springboot.employee.entity;

public class DemoData {
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
	public DemoData(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
