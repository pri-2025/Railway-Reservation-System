package com.railway.service;

import java.util.Scanner;
import com.railway.model.User;
import com.railway.repo.URepo;
import com.railway.session.Session;
import com.railway.util.PUtil;

public class PSvc {

	Scanner sc = new Scanner(System.in);
	URepo UR = new URepo();

	public void register() {

		System.out.print("Choose username: ");
		String username = sc.nextLine();
		if (UR.exists(username)) {
			System.out.println("Username already exists!");
			return;
		}

		System.out.print("Enter email: ");
		String email = sc.nextLine();
		if (!PUtil.eVal(email))
			return;

		System.out.print("Enter mobile: ");
		long mob = sc.nextLong();
		sc.nextLine();
		if (!PUtil.mobVal(mob))
			return;

		System.out.print("Enter password: ");
		String pswd = sc.nextLine();
		if (!PUtil.pswdVal(pswd))
			return;

		UR.save(new User(username, pswd, email, mob));
		System.out.println("Registration successful!");
	}

	public void login() {

	    System.out.print("Username: ");
	    String uname = sc.nextLine();

	    System.out.print("Password: ");
	    String pwd = sc.nextLine();

	    User user = UR.getByUsername(uname);

	    if (user != null && user.getPassword().equals(pwd)) {
	        Session.currUser = user;   // 🔴 REQUIRED
	        System.out.println("Login successful!");
	    } else {
	        System.out.println("Invalid credentials!");
	    }
	}


	public void profile() {
		if (Session.currUser == null) {
			System.out.println("Please login first!");
			return;
		}
		System.out.println(Session.currUser);
	}
}
