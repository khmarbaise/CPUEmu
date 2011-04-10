package com.soebes.jacem.parser;

public class Label {

	private String name;
	private int value;

	public Label(String name, int val) {
		super ();
		setName(name);
		setValue(val);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
