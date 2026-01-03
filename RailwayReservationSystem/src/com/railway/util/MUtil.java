package com.railway.util;

import com.railway.session.Session;

public class MUtil {

	public static void showPublicMenu() {
		System.out.println("""
				*********************** IRCTC RAILWAY PORTAL ***********************

				1. Register
				2. Login
				3. View Trains
				4. Exit
				""");
	}

	public static void showDashboardMenu() {
		System.out.println("""
				*********************** DASHBOARD ***********************

				Logged in as: %s

				1. Search Trains
				2. Check Seat Availability
				3. Book Ticket
				4. View PNR Status
				5. Booking History
				6. Cancel Ticket
				7. View / Update Profile
				8. Logout
				
				""".formatted(Session.currUser.getUsername()));
	}
}
