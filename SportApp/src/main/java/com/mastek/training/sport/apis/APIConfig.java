package com.mastek.training.sport.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class APIConfig extends ResourceConfig {

	public APIConfig() {
		register(PlayerService.class);
		register(TeamsService.class);
		register(VenueLocationService.class);
	}
	
}
