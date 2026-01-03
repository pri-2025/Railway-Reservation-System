package com.railway.model;

public class Station {
	
	private String code;
	private String name;

	public Station(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return code + " (" + name + ")";
	}
}
