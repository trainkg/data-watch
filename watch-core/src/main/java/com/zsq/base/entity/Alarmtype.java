package com.zsq.base.entity;

/**
 * @author zhuyy
 */
public class Alarmtype {

	private int id;
	private int address;
	private String value;
	private String name;

	
	/*----------------------------------------------------*
	 * GET/SET
	 *----------------------------------------------------*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
