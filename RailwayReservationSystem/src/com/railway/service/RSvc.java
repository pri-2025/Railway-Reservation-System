package com.railway.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.railway.model.*;
import com.railway.repo.*;
import com.railway.util.*;

public class RSvc {

    RRepo RR = new RRepo();
    TRepo TR = new TRepo();
    PRepo PR = new PRepo();
    RUtil RU = new RUtil();
    Scanner sc = new Scanner(System.in);

    public void bookTicket() {

        System.out.print("Enter Train ID: ");
        int tid = sc.nextInt();
        sc.nextLine();

        Train t = TR.getTrainById(tid);
        if (t == null) {
            System.out.println("Invalid Train ID!");
            return;
        }

        System.out.print("Enter Username: ");
        String username = sc.next();

        Passenger p = PR.getPsgByUn(username);
        if (p == null) {
            System.out.println("Passenger not registered!");
            return;
        }

        String pnr = RU.generatePNR();
        LocalDate date = LocalDate.now();

        Reservation r;

        if (t.getAvailable_seats() > 0) {
            t.setAvailable_seats(t.getAvailable_seats() - 1);
            r = new Reservation(pnr, t, p, date, "CONFIRMED");
            System.out.println("Ticket Confirmed!");
        } else {
            r = new Reservation(pnr, t, p, date, "WAITING");
            RR.waitingList.add(r);
            System.out.println("Added to Waiting List");
        }

        RR.saveReservation(r);
        System.out.println("PNR: " + pnr);
    }

    public void viewBooking() {

        System.out.print("Enter PNR: ");
        String pnr = sc.next().trim();

        Reservation r = RR.getByPnr(pnr);
        if (r == null) {
            System.out.println("No booking found!");
            return;
        }

        System.out.println(r);
    }

    public void history() {

        System.out.print("Enter Username: ");
        String username = sc.next().trim();

        Passenger p = PR.getPsgByUn(username);
        if (p == null) {
            System.out.println("Passenger not registered!");
            return;
        }

        var list = RR.getHistory(username);
        
        if (list.isEmpty()) {
            System.out.println("No booking history!");
            return;
        }

        for (Reservation r : list) {
            System.out.println("----------------------");
            System.out.println(r);
        }
    }

    public void cancelTicket() {

        System.out.print("Enter PNR to cancel: ");
        String pnr = sc.next().trim();

        Reservation r = RR.getByPnr(pnr);
        if (r == null) {
            System.out.println("Invalid PNR!");
            return;
        }

        r.setStatus("CANCELLED");
        RR.remove(pnr);

        Train t = r.getTrain();
        t.setAvailable_seats(t.getAvailable_seats() + 1);

        if (!RR.waitingList.isEmpty()) {
            Reservation next = RR.waitingList.poll();
            next.setStatus("CONFIRMED");
            t.setAvailable_seats(t.getAvailable_seats() - 1);
            System.out.println("Waiting ticket promoted: " + next.getPnr());
        }

        System.out.println("Ticket Cancelled Successfully");
    }
}
