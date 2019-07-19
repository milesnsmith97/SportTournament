package com.mastek.training.sport;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.sport.apis.VenueLocationService;
import com.mastek.training.sport.entities.VenueLocation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VenueApplicationTest {

	@Autowired
	VenueLocationService venueService;
	
	@Autowired
	VenueLocation venue;
	
//	@Test
//	public void addVenueUsingService() {
//		venue.setVenueno(1);
//		venue.setVenueName("Default Venue Name");
//		venue.setLocation("Default Location");
//		venue = venueService.registerOrUpdateVenue(venue);
//		assertNotNull(venue);
//	}
	
//	@Test
//	public void findByVenuenoUsingService() {
//		int venueno = 60;
//		assertNotNull(venueService.findByVenueno(venueno));
//	}
//	
//	@Test
//	public void deleteByVenuenoUsingService() {
//		int venueno = 64;
//		venueService.deleteByVenueno(venueno);
//		assertNull(venueService.findByVenueno(venueno));
//	}
}
