package com.railway.service;

import java.util.Scanner;
import com.railway.model.Train;
import com.railway.repo.TRepo;
import com.railway.util.TUtil;

public class TSvc {

	TRepo TR = new TRepo();
	TUtil tutil = new TUtil();
	Scanner sc = new Scanner(System.in);

	public void viewTrains() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------Available Trains------------------------------------");
		System.out.println();
		tutil.printHeader();
		for (Train i : TR.getTrains()) {
			System.out.println(i);
		}
	}

	public void chkTrAvail() {
		// TODO Auto-generated method stub
		System.out.print("Enter source : ");
		String src = sc.nextLine();
		System.out.print("Enter destination : ");
		String dest = sc.nextLine();
		System.out.println();

		boolean found = false;
		int id = 0;

		System.out.println("------------------------------------Available Trains------------------------------------");
		System.out.println();
		for (Train i : TR.getTrains()) {
			if (i.getT_Src().equalsIgnoreCase(src) && i.getT_Dest().equalsIgnoreCase(dest)) {
				System.out.println(i);
				id = i.getT_id();
				found = true;
			}
		}
		if (!found) {
			System.out.println("No trains available for this route.");
			System.out.println();
		}
		System.out.println();
		System.out.print("Want to check available seats? (y for yes and n for no) : ");
		char ans = sc.next().charAt(0);
		System.out.println();

		if (ans == 'Y' || ans == 'y') {
			chkStAvail(id);
		}
		else if(ans == 'N' || ans == 'n') {
			return;
		}
		else {
			System.out.println("Please enter either 'y' or 'n' for yes or no resp. !");
		}
	}

	 public void chkStAvail(int tid) {
	        Train t = TR.getTrainById(tid);
	        if (t == null) {
	            System.out.println("Invalid Train ID!");
	            return;
	        }
	        System.out.println("Available Seats: " + t.getAvailable_seats());
	        System.out.println("Fare per seat: " + t.getFare());
	    }

}
