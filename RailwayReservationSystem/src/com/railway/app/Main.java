package com.railway.app;

import java.util.Scanner;
import com.railway.service.*;
import com.railway.session.Session;
import com.railway.util.MUtil;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PSvc PS = new PSvc();
		RSvc RS = new RSvc();
		TSvc TS = new TSvc();
		MUtil MU = new MUtil();

		while (true) {

			if (Session.currUser == null) {
				MU.showPublicMenu();
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println();

				switch (choice) {
				case 1:
					PS.register();
					System.out.println();
					break;
				case 2:
					PS.login();
					System.out.println();
					break;
				case 3:
					TS.viewTrains();
					System.out.println();
					break;
				case 4:
					System.out.println("Thank you for using IRCTC!");
					System.out.println();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice!");
					System.out.println();
					break;
				}

			} else {
				MU.showDashboardMenu();
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println();

				switch (choice) {
				case 1:
					TS.viewTrains();
					System.out.println();
					break;
				case 2:
					TS.chkTrAvail();
					System.out.println();
					break;
				case 3:
					RS.bookTicket();
					System.out.println();
					break;
				case 4:
					RS.viewBooking();
					System.out.println();
					break;
				case 5:
					RS.history();
					break;
				case 6:
					RS.cancelTicket();
					System.out.println();
					break;
				case 7:
					PS.profile();
					System.out.println();
					break;
				case 8:
					Session.currUser = null;
					System.out.println("Logged out successfully!");
					System.out.println();
					break;
				default:
					System.out.println("Invalid choice!");
					System.out.println();
					break;
				}
			}
		}
	}
}
