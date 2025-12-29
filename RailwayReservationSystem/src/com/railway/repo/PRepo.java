package com.railway.repo;

import java.util.ArrayList;
import com.railway.model.Passenger;

public class PRepo {
	
	Passenger P = new Passenger();
	
	ArrayList <Passenger> psg = new ArrayList<>();
	
	public void add(Passenger p) {
		psg.add(p);
	}
	
	public Passenger getPsgByUn(String username) {
		for(Passenger p : psg) {
			if(P.getUsername().equals(username)){
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Passenger> getPsgs(){
		return psg;
	}
}
