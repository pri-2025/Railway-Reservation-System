package com.railway.model;

public class Passenger {

	private String name;
	private int age;
	private char gender;

	public Passenger(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return name + " (" + age + ", " + gender + ")";
	}
}
