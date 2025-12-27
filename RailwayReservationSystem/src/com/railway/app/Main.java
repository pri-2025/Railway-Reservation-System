package com.railway.app;

import java.util.Scanner;

import com.railway.service.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PSvc P = new PSvc();
		RSvc R = new RSvc();
		TSvc T = new TSvc();

		Scanner sc = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("------------Welcome to Railway Reservation Portal-----------");
			System.out.println();
			System.out.println("1. Register"); // first time registration
			System.out.println("2. Login"); // fetch frm bkend and log in the person
			System.out.println("3. View Trains"); // enter dates, source, destination and then view trains
			System.out.println("4. Check availability"); // select the particular train n check avail. on those dates
			System.out.println("5. Book Tickets"); // have add passenger thingy, and generate final ticket thingy
			System.out.println("6. Cancel Tickets"); // single or multiple tickets cancellation
			System.out.println("7. View PNR details"); // check the booking and also display the status if waiting
			System.out.println("8. History"); // see previous bookings
			System.out.println("9. View Profile"); // give option for update profile here
			System.out.println("10. Exit");
			System.out.println();
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
				P.register();
				System.out.println();
				break;
			case 2:
				P.login();
				System.out.println();
				break;
			case 3:
				T.viewTrains();
				System.out.println();
				break;
			case 4:
				T.chkAvail();
				System.out.println();
				break;
			case 5:
				R.bookTicket();
				System.out.println();
				break;
			case 6:
				R.bookTicket();
				System.out.println();
				break;
			case 7:
				R.viewBooking();
				System.out.println();
				break;
			case 8:
				R.history();
				System.out.println();
				break;
			case 9:
				P.profile();
				System.out.println();
				break;
			case 10:
				System.out.println("Exiting....");
				System.out.println("Thank you for visiting us! \nVisit again!!");
				System.out.println();
				break;
			default:
				System.out.println("Invalid choice!");
				System.out.println("Please enter between 1-10 only!");
				System.out.println();
				break;
			}

		} while (choice != 10);
	}

}
