package com.railway.repo;

import java.util.ArrayList;
import com.railway.model.Train;

public class TRepo {

	public ArrayList<Train> trains = new ArrayList<>();

	public TRepo() {
		t_list();
	}

	public void t_list() {
	    getTrains().add(new Train(106, "Jan Shatabdi", "Pune", "Hyderabad", 300, 95, 700));
	    getTrains().add(new Train(101, "Rajdhani Express", "Pune", "Vadodara", 500, 120, 2500));
	    getTrains().add(new Train(109, "Intercity Express", "Pune", "Bangalore", 420, 180, 1400));
	    getTrains().add(new Train(104, "Garib Rath", "Delhi", "Mumbai", 600, 350, 900));
	    getTrains().add(new Train(107, "Tejas Express", "Pune", "Hyderabad", 280, 60, 2200));
	    getTrains().add(new Train(102, "Shatabdi Express", "Pune", "Vadodara", 400, 85, 1200));
	    getTrains().add(new Train(110, "Sampark Kranti", "Pune", "Bangalore", 550, 300, 1300));
	    getTrains().add(new Train(105, "Vande Bharat", "Delhi", "Mumbai", 350, 40, 1800));
	    getTrains().add(new Train(108, "Humsafar Express", "Pune", "Hyderabad", 500, 210, 1600));
	    getTrains().add(new Train(103, "Duronto Express", "Pune", "Vadodara", 450, 200, 2800));
	}


	public ArrayList<Train> getTrains() {
		return trains;
	}
	
	public Train getTrainById(int id) {
        for (Train i : trains) {
            if (i.getT_id() == id) {
            	return i;
            }
        }
        return null;
    }

}
