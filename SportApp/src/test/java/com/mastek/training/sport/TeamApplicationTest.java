package com.mastek.training.sport;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.sport.apis.TeamsService;
import com.mastek.training.sport.entities.Teams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamApplicationTest {

	@Autowired
	TeamsService teamService;
	
	@Autowired
	Teams team;
	
	@Test
	public void addTeamUsingService() {
		team.setTeamno(1);
		team.setName("Default Team Name");
		team.setNationality("Default Nationality");
		team = teamService.registerOrUpdateTeam(team);
		assertNotNull(team);
	}
	
	@Test
	public void findByTeamnoUsingService() {
		int teamno = 57;
		assertNotNull(teamService.findByTeamno(teamno));
	}
//	
//	@Test
//	public void deleteByTeamnoUsingService() {
//		int teamno = 58;
//		teamService.deleteByTeamno(teamno);
//		assertNull(teamService.findByTeamno(teamno));
//	}
//	
	
	
	
	
	
	
	
	
}
