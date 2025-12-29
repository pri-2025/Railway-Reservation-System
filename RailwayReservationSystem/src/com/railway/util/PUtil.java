package com.railway.util;

import com.railway.model.Passenger;
import com.railway.repo.PRepo;
import com.railway.service.PSvc;

public class PUtil {

	Passenger P = new Passenger();
	PRepo PR = new PRepo();
	PSvc PS = new PSvc();

	public static boolean aadharVal(Long pId) {
		String num = Long.toString(pId);
		if (num.length() != 12) {
			System.out.println("Invalid Aadhar no.!");
			return false;
		}
		return true;

	}

	public static boolean nameVal(String name) {
		for (char c : name.toCharArray()) {
			if (Character.isDigit(c)) {
				System.out.println("Invalid name!");
				return false;
			}
		}
		return true;
	}

	public static boolean ageVal(int age) {
		if (age <= 0) {
			System.out.println("Invalid age!");
			return false;
		}
		return true;
	}

	public static boolean genVal(char gen) {
		if (gen != 'M' || gen != 'F' || gen != 'O') {
			System.out.println("Please select from M,F and O only!");
			return false;
		}
		return true;
	}

	public static boolean mobVal(long mob) {
		String num = Long.toString(mob);
		if (num.length() != 10) {
			System.out.println("Mobile number should be of 10 digits!");
			return false;
		}
		for (char c : num.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				System.out.println("No letters allowed! \nPlease enter digits only!");
				return false;
			}
		}
		return true;
	}
	
	public static boolean eVal(String email) {

	    if (email == null) {
	        System.out.println("Email cannot be null!");
	        return false;
	    }
	    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    
	    if (!email.matches(regex)) {
	        System.out.println("Invalid email format!");
	        return false;
	    }

	    return true;
	}


	public static boolean pswdVal(String pswd) {
		if (pswd.length() < 8) {
			return false;
		}
		boolean upper = false;
		boolean digit = false;
		boolean spcSym = false;

		for (char c : pswd.toCharArray()) {
			if (Character.isUpperCase(c)) {
				upper = true;
			}
			if (Character.isDigit(c)) {
				digit = true;
			}
			if (!Character.isLetterOrDigit(c)) {
				spcSym = true;
			}
		}

		return upper && digit && spcSym;
	}

}
