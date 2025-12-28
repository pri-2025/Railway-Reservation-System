package com.railway.model;

import java.time.LocalDate;

public class Reservation {
	private String pnr;
	private Train train;
	private Passenger passenger;
	private LocalDate date;
	private String status;

	public Reservation(String pnr, Train train, Passenger passenger, LocalDate date, String status) {
		this.pnr = pnr;
		this.train = train;
		this.passenger = passenger;
		this.date = date;
		this.status = status;
	}

	public Reservation() {

	}

	public String getPnr() {
		return pnr;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PNR: " + pnr + "\nTrain: " + train + "\nPassenger: " + passenger.getP_id() + "\nJourney Date: " + date
				+ "\nStatus: " + status;
	}
}
