package com.railway.model;

public class Train {
	
	private int t_id;
	private String t_name;
	private String t_source;
	private String t_dest;
	private int tot_seats;
	private int avail_seats;
	private double fare;

	public Train(int t_id, String t_name, String t_source, String t_dest, int tot_seats, int avail_seats, double fare) {
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_source = t_source;
		this.t_dest = t_dest;
		this.tot_seats = tot_seats;
		this.avail_seats = avail_seats;
		this.fare = fare;
	}

	public Train() {

	}

	public int getT_id() {
		return t_id;
	}

	public String getT_Src() {
		return t_source;
	}

	public String getT_Dest() {
		return t_dest;
	}

	public int getAvailable_seats() {
		return avail_seats;
	}

	public void setAvailable_seats(int avail_seats) {
		this.avail_seats = avail_seats;
	}

	public double getFare() {
		return fare;
	}

	@Override
	public String toString() {
		return String.format("%-10d | %-20s | %-28s | Seats: %-4d | Fare: ₹%-7.2f", t_id, t_name,
				String.format("%-12s → %-12s", t_source, t_dest), avail_seats, fare);
	}
}
