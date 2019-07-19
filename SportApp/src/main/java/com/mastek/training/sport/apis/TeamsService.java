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

import com.mastek.training.sport.entities.Teams;
import com.mastek.training.sport.repositories.TeamRepository;

@Component
@Scope("singleton")
@Path("/teams/")
public class TeamsService {

	@Autowired
	private TeamRepository teamRepository;
	
	@POST
	@Path("/register/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Teams registerOrUpdateTeam(
			@BeanParam Teams team) {
		team = teamRepository.save(team);
		System.out.println("Team Registered "+team);
		return team;
	}
	
	@Path("/find/{teamno}")
	@GET
	@Produces({
		MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML
	})
	public Teams findByTeamno(
			@PathParam("teamno") int teamno) {
		try {
			return teamRepository.findById(teamno).get();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DELETE
	@Path("/delete/{teamno}")
	public void deleteByTeamno(int teamno) {
		teamRepository.deleteById(teamno);
	}
}
