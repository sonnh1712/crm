package com.crm.model;

public class Role {

	private int id;
	private String name;
	private String des;

	public Role(int id, String name, String des) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
	}

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

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
