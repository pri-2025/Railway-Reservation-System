package com.railway.model;

public class Passenger {
	private int p_id; // aadhar
	private String name;
	private int age;
	private char gen;
	private long mobNo;
	private String email;

	public Passenger(int p_id, String name, int age, char gen, long mobNo, String email) {
		this.p_id = p_id;
		this.name = name;
		this.age = age;
		this.gen = gen;
		this.mobNo = mobNo;
		this.email = email;
	}

	public Passenger() {

	}

	public int getP_id() {
		return p_id;
	}

	@Override
	public String toString() {
		return "Passenger ID: " + p_id + "\nName: " + name + "\nAge: " + age + "\nGender: " + gen + "\nMobile: " + mobNo
				+ "\nEmail: " + email;
	}
}
