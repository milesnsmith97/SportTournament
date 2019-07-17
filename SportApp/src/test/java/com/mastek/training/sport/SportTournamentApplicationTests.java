package com.mastek.training.sport;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.sport.apis.PlayerService;
import com.mastek.training.sport.apis.TeamsService;
import com.mastek.training.sport.apis.VenueLocationService;
import com.mastek.training.sport.entities.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SportTournamentApplicationTests {

	@Autowired
	PlayerService playerService;
	
	@Autowired
	TeamsService teamService;
//	
//	@Autowired
//	VenueLocationService venueService;
	
	@Autowired
	Player play;
	
	@Test
	public void addPlayerUsingService() {
		play.setPlayerno(1);
		play.setName("New player 5");
		play.setSalary(2000);
		play = playerService.registerOrUpdatePlayer(play);
		assertNotNull(play);
	}
	
	@Test
	public void findByPlayernoUsingService() { 
		int playerno = 50;
		assertNotNull(playerService.findByPlayerno(playerno));
	}
	
	@Test
	public void deleteByPlayernoUsingService() {
		int playerno = 49;
		playerService.deleteByPlayerno(playerno);
		assertNull(playerService.findByPlayerno(playerno));
	}
	
	@Test
	public void simpleTest() {
		System.out.println();
	}
	

}
