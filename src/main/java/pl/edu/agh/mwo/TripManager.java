package pl.edu.agh.mwo;

import java.util.*;
import java.util.Map.Entry;

public class TripManager {
	private HashMap<String, Trip> tripList;

	public TripManager() {
		tripList = new HashMap<String, Trip>();
	}

	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		} else {
			tripList.put(trip.getName(), trip);
		}
	}

	public HashMap<String, Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}

	public Collection<Trip> findTrip(String keyword) {
		Collection<Trip> tripsFound = new HashSet<Trip>();
		for (Entry<String, Trip> trip : tripList.entrySet()) {
			if (keyword.isEmpty() || trip.getKey().contains(keyword)
					|| trip.getValue().getDescription().contains(keyword)) {
				tripsFound.add(trip.getValue());
			}
			if (trip.getValue().getPhotos() != null) {
				for (Photo photo : trip.getValue().getPhotos()) {
					if (photo.getComment().contains(keyword)) {
						tripsFound.add(trip.getValue());
					}
				}
			}
		}
		return tripsFound;
	}

}
