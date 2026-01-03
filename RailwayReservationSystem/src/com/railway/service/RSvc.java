package com.railway.service;

import java.time.LocalDate;
import java.util.*;

import com.railway.model.*;
import com.railway.repo.*;
import com.railway.session.Session;
import com.railway.util.RUtil;

public class RSvc {

    Scanner sc = new Scanner(System.in);
    TRepo TR = new TRepo();
    BRepo bRepo = new BRepo();

    public void bookTicket() {

        if (Session.currUser == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.print("Enter Train ID: ");
        int tid = sc.nextInt();
        System.out.println();

        Train t = TR.getTrainById(tid);
        if (t == null) {
            System.out.println("Invalid Train ID!");
            return;
        }

        System.out.print("Number of passengers: ");
        int n = sc.nextInt();
        System.out.println();

        List<Passenger> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Passenger " + i);
            System.out.print("Name: ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Gender: ");
            char g = sc.next().charAt(0);
            System.out.println();

            list.add(new Passenger(name, age, g));
        }
        
        if (t.getAvailable_seats() < n) {
            System.out.println("Not enough seats available!");
            return;
        }

        t.setAvailable_seats(t.getAvailable_seats() - n);

        String pnr = RUtil.generatePNR();
        Booking b = new Booking(
                pnr, t, Session.currUser,
                list, LocalDate.now(), "CONFIRMED"
        );

        bRepo.save(b);
        System.out.println();
        System.out.println("Ticket booked!");
        System.out.println();
        System.out.println(b);
    }

    public void viewBooking() {
        System.out.print("Enter PNR: ");
        String pnr = sc.nextLine();
        sc.nextLine();
        Booking b = bRepo.getByPnr(pnr);
        if (b == null) {
            System.out.println("No booking found!");
            return;
        }
        System.out.println(b);
    }

    public void history() {
        if (Session.currUser == null) {
            System.out.println("Login first!");
            return;
        }
        var list = bRepo.history(Session.currUser.getUsername());
        if (list.isEmpty()) {
            System.out.println("No history!");
            return;
        }
        list.forEach(System.out::println);
    }

    public void cancelTicket() {

        if (Session.currUser == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.print("Enter PNR to cancel: ");
        String pnr = sc.nextLine();

        Booking b = bRepo.getByPnr(pnr);

        if (b == null) {
            System.out.println("Invalid PNR!");
            return;
        }

        // Security check (VERY IMPORTANT)
        if (!b.getUser().getUsername()
                .equals(Session.currUser.getUsername())) {
            System.out.println("You cannot cancel someone else's ticket!");
            return;
        }

        b.setStatus("CANCELLED");

        // Restore seats
        Train t = b.getTrain();
        t.setAvailable_seats(
            t.getAvailable_seats() + b.getPassengers().size()
        );

        bRepo.remove(pnr);

        System.out.println("Ticket cancelled successfully!");
    }

}
