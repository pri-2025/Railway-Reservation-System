package com.railway.model;

public class User {

	private String username;
	private String name;
	private String password;
	private String email;
	private long mobile;

	public User(String username, String password, String email, long mobile) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public User(String username, String name, String password, String email, long mobile) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public long getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		return """
				===== USER PROFILE =====
				Username : %s
				Name     : %s
				Email    : %s
				Mobile   : %s
				""".formatted(username, name, email, mobile);
	}

}
