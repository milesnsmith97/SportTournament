package com.mastek.training.sport.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sport.entities.VenueLocation;
import com.mastek.training.sport.repositories.VenueLocationRepository;

@Component
@Scope("singleton")
@Path("/venues/")
public class VenueLocationService {

	@Autowired
	private VenueLocationRepository venueRepository;
	
	@POST
	@Path("/register/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public VenueLocation registerOrUpdateVenue(
			@BeanParam VenueLocation venue) {
		venue = venueRepository.save(venue);
		System.out.println("Venue Registered "+venue);
		return venue;
	}
	
	@Path("/find/{venueno}")
	@GET
	@Produces({
		MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML
	})
	public VenueLocation findByVenueno(
			@PathParam("venueno") int venueno) {
		try {
			return venueRepository.findById(venueno).get();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DELETE
	@Path("/delete/{venueno}")
	public void deleteByVenueno(int venueno) {
		venueRepository.deleteById(venueno);
	}
}
