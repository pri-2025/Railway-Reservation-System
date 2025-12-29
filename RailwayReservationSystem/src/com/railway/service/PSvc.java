package com.railway.service;

import java.util.Scanner;

import com.railway.model.Passenger;
import com.railway.repo.PRepo;
import com.railway.util.PUtil;

public class PSvc {

	PRepo PR = new PRepo();
	Passenger P = new Passenger();

	Scanner sc = new Scanner(System.in);

	public void register() {
		// TODO Auto-generated method stub
		System.out.print("Enter Aadhaar ID: ");
		long pid = sc.nextLong();
		sc.nextLine();
		if(!PUtil.aadharVal(pid)) {
			return;
		}

		System.out.print("Choose username: ");
		String username = sc.nextLine();

		System.out.print("Enter name: ");
		String name = sc.nextLine();

		System.out.print("Enter age: ");
		int age = sc.nextInt();

		System.out.print("Choose gender (M/F/O): ");
		char gen = sc.next().charAt(0);

		System.out.print("Enter mobile number: ");
		long mobNo = sc.nextLong();
		sc.nextLine();
		if(!PUtil.mobVal(mobNo)) {
			return;
		}

		System.out.print("Enter email: ");
		String email = sc.nextLine();

		System.out.print("Enter password: ");
		String pswd = sc.nextLine();
		if (!PUtil.pswdVal(pswd)) {
			System.out.println("Invalid password format!");
			return;
		}

		Passenger p = new Passenger(pid, username, name, age, gen, mobNo, email, pswd);
		PR.add(p);

		System.out.println();
		System.out.println("Registration successful!");
	}

	public void login() {
		// TODO Auto-generated method stub
		System.out.print("Enter username: ");
		String uname = sc.nextLine();

		System.out.print("Enter password: ");
		String pswd = sc.nextLine();
		
		boolean found = false;

		for(Passenger p : PR.getPsgs()) {
			if(p.getUsername().equals(uname) && p.getPswd().equals(pswd)) {
				System.out.println();
				System.out.println("Login successful!");
				found = true;
				break;
			}
		}
		
		if(!found) {
			System.out.println("Invalid credintials! \nRegister yourself first, if you haven't.");
		}
		

	}

	public void profile() {
		// TODO Auto-generated method stub
		for(Passenger p : PR.getPsgs()) {
			System.out.println(p);
		}
	}

}
