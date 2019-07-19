package com.mastek.training.sport.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mastek.training.sport.entities.Player;
import com.mastek.training.sport.entities.Teams;
import com.mastek.training.sport.repositories.PlayerRepository;

@Component
@Scope("singleton")
@Path("/players/")
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamsService teamService;
	
	@Autowired
	private VenueLocationService venueService;
	
	public PlayerService() {
		System.out.println("Player Service Created");
	}
	
	@POST
	@Path("/register/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)	
	public Player registerOrUpdatePlayer(
			@BeanParam Player play) {
		play = playerRepository.save(play);
		System.out.println("Player Registered "+play);
		return play;
	}
	
	@Path("/find/{playerno}")
	@GET
	@Produces ({
		MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML
	})
	public Player findByPlayerno(
			@PathParam("playerno") int playerno) {
		try {
			return playerRepository.findById(playerno).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("/delete/{playerno}")
	public void deleteByPlayerno(int playerno) {
		playerRepository.deleteById(playerno);
	}

	@Transactional
	@POST
	@Path("/assign/team")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Player assignTeam(
			@FormParam("playerno") int playerno, 
			@FormParam("teamno")int teamno) {
		try {
			Player play = findByPlayerno(playerno);
			Teams team = teamService.findByTeamno(teamno);
			
			team.getMembers().add(play);
			play.setCurrentTeam(team);
			
			registerOrUpdatePlayer(play);
			return play;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}



















