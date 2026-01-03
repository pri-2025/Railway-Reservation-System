package com.railway.repo;

import java.util.*;
import com.railway.model.Booking;

public class BRepo {
	private static Map<String, Booking> pnrMap = new HashMap<>();
	private static Map<String, List<Booking>> history = new HashMap<>();

	public void save(Booking b) {
		pnrMap.put(b.getPnr(), b);
		history.computeIfAbsent(b.getUser().getUsername(), k -> new ArrayList<>()).add(b);
	}

	public Booking getByPnr(String pnr) {
		return pnrMap.get(pnr);
	}

	public List<Booking> history(String username) {
		return history.getOrDefault(username, new ArrayList<>());
	}

	public void cancel(String pnr) {
		pnrMap.remove(pnr);
	}

	public void remove(String pnr) {
	    pnrMap.remove(pnr);
	}

}
