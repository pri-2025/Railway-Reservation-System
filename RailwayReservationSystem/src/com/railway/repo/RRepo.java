package com.railway.repo;

import java.util.*;
import com.railway.model.Reservation;

public class RRepo {

	public static HashMap<String, Reservation> pnrMap = new HashMap<>();

	public static Queue<Reservation> waitingList = new LinkedList<>();

	public static HashMap<String, List<Reservation>> historyMap = new HashMap<>();

	public void saveReservation(Reservation r) {
		pnrMap.put(r.getPnr(), r);

		historyMap.computeIfAbsent(r.getPassenger().getUsername(), // ✅ USERNAME
				k -> new ArrayList<>()).add(r);
	}

	public Reservation getByPnr(String pnr) {
		return pnrMap.get(pnr);
	}

	public List<Reservation> getHistory(String username) {
		return historyMap.getOrDefault(username, new ArrayList<>());
	}

	public void remove(String pnr) {
		pnrMap.remove(pnr);
	}
}
