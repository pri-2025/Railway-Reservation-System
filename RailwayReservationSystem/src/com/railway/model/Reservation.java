package com.railway.model;

import java.time.LocalDate;

public class Reservation implements Comparable<Reservation> {

    private String pnr;
    private Train train;
    private Passenger passenger;
    private LocalDate date;
    private String status; // CONFIRMED / WAITING / CANCELLED

    public Reservation(String pnr, Train train, Passenger passenger,
                       LocalDate date, String status) {
        this.pnr = pnr;
        this.train = train;
        this.passenger = passenger;
        this.date = date;
        this.status = status;
    }

    public String getPnr() {
        return pnr;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Reservation o) {
        // older reservation gets priority
        return this.pnr.compareTo(o.pnr);
    }

    @Override
    public String toString() {
        return "PNR: " + pnr +
               "\nTrain: " + train +
               "\nPassenger: " + passenger.getP_id() +
               "\nDate: " + date +
               "\nStatus: " + status;
    }
}
