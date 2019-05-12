package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
	Photo photo;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
		photo = new Photo("komentarz");
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
//		fail("chcemy zespuc");
		}
	
	@Test
	public void testFindTripName() throws Exception {
		tripManager.add(trip);
//		tripManager.findTrip("nazwa");
		assertEquals(1, tripManager.findTrip("nazwa").size());
		}
	
	@Test
	public void testFindTripDescription() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.findTrip("opis").size());
		}
	
	@Test
	public void testFindTripPhoto() throws Exception {
		tripManager.add(trip);
		trip.addPhoto(photo);
		assertEquals(1, tripManager.findTrip("komentarz").size());
		}
	
	@Test
	public void testFindTripNull() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.findTrip("").size());
		}
	
	
}
