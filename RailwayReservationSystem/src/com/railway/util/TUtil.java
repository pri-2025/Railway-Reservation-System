package com.railway.util;

public class TUtil {
	public static void printHeader() {
	    System.out.println(
	        "--------------------------------------------------------------------------------------------");
	    System.out.printf(
	        "%-10s | %-20s | %-28s | %-10s | %-12s%n",
	        "Train No",
	        "Train Name",
	        "Route",
	        "Seats",
	        "Fare"
	    );
	    System.out.println(
	        "--------------------------------------------------------------------------------------------");
	}

}
