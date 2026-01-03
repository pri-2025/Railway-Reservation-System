package com.railway.repo;

import java.util.ArrayList;
import com.railway.model.Passenger;

public class PRepo {
	
	public static ArrayList <Passenger> psg = new ArrayList<>();
	
	public void add(Passenger p) {
		psg.add(p);
	}
	
	public Passenger getPsgByUn(String username) {
	    for (Passenger p : psg) {
	        if (p.getUsername().equals(username)) {
	            return p;
	        }
	    }
	    return null;
	}

	
	public ArrayList<Passenger> getPsgs(){
		return psg;
	}
	
	public Passenger getPassengerById(long pid) {
	    for (Passenger p : psg) {
	        if (p.getP_id() == pid) {
	            return p;
	        }
	    }
	    return null;
	}

}
