package com.railway.model;

import java.time.LocalDate;
import java.util.List;

public class Booking {

	private String pnr;
	private Train train;
	private User user;
	private List<Passenger> passengers;
	private LocalDate journeyDate;
	private String status;

	public Booking(String pnr, Train train, User user, List<Passenger> passengers, LocalDate journeyDate,
			String status) {
		this.pnr = pnr;
		this.train = train;
		this.user = user;
		this.passengers = passengers;
		this.journeyDate = journeyDate;
		this.status = status;
	}

	public String getPnr() {
		return pnr;
	}

	public User getUser() {
		return user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return """
				------------------------------
				PNR: %s
				Train: %s
				Date: %s
				Status: %s
				Passengers: %s
				------------------------------
				""".formatted(pnr, train, journeyDate, status, passengers);
	}

	public Train getTrain() {
	    return train;
	}

	public List<Passenger> getPassengers() {
	    return passengers;
	}
}
