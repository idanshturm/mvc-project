package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import database.Database;
import utilities.Attraction;
import utilities.Order;
import utilities.ParkAdmin;

class UniTest {
	
	Database db = Database.getInstance();

	@Test
	public void addEmployeeTest() {  // Test if admin was added
		
		
		ParkAdmin parkAdmin = new ParkAdmin();
		
		parkAdmin.setId("123456");
		parkAdmin.setPassword("123456");
		
		db.addParkAdmin(parkAdmin);
		
		assertTrue(db.testIsParkAdmin(parkAdmin.getId(), parkAdmin.getPassword()));
	}
	
	@Test
	public void deleteParkAdminTest() { // Test if admin was deleted
		
		
		ParkAdmin parkAdmin = new ParkAdmin();
		
		parkAdmin.setId("123456");
		parkAdmin.setPassword("123456");
		
		db.testDeleteParkAdmin(parkAdmin.getId());
		assertFalse(db.testIsParkAdmin(parkAdmin.getId(), parkAdmin.getPassword()));
	}
	
	@Test
	public void addAttractionTest() { // Test if Attraction was added
		
		Attraction attraction = new Attraction("test_id", "test_park_id", "test_name", "test_description", true, true, true, true, true, true);
		
		db.addAttraction(attraction);
		
		assertTrue(db.isAttractionExist(attraction.getId(), attraction.getParkId()));
	}
	
	@Test
	public void deleteAttractionTest() { // Test if attraction was deleted
		
		
		Attraction attraction = new Attraction("test_id", "test_park_id", "test_name", "test_description", true, false, true, true, true, true);
		
		db.deleteAttraction(attraction.getId(), attraction.getParkId());
		assertFalse(db.isAttractionExist(attraction.getId(), attraction.getParkId()));
	}	
	
	@Test
	public void ordesCalculationTest() {
		
		int  w, x, y, z;
		
		w = 1;
		x = 1;
		y = 1;
		z = 1;
		
		Order order = new Order("id_test", "park_id_test", "name_test", "0000000", w, x, y, z);
		
		int totalAmount = (w * 20) + (x * 15) + (y * 10) + (z * 10);
		
		assertEquals(order.getTotalPrice(), totalAmount);
		
		w = 1;
		x= 1;
		y = 1;
		z = 1;
	}

}
