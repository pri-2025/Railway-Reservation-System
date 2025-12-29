package com.railway.model;

public class Passenger {

	private long p_id; // Aadhaar / unique ID
	private String username; // LOGIN ID
	private String name;
	private int age;
	private char gen;
	private long mobNo;
	private String email;
	private String pswd;

	public Passenger(long p_id, String username, String name, int age, char gen, long mobNo, String email, String pswd) {
		this.p_id = p_id;
		this.username = username;
		this.name = name;
		this.age = age;
		this.gen = gen;
		this.mobNo = mobNo;
		this.email = email;
		this.pswd = pswd;
	}

	public Passenger() {

	}

	public long getP_id() {
		return p_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPswd() {
		return pswd;
	}

	@Override
	public String toString() {
		return "Passenger ID: " + p_id + "\nUsername: " + username + "\nName: " + name + "\nAge: " + age + "\nGender: "
				+ gen + "\nMobile: " + mobNo + "\nEmail: " + email;
	}
}
