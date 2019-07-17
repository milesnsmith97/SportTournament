package com.mastek.training.sport.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sport.entities.Teams;
import com.mastek.training.sport.repositories.TeamRepository;

@Component
@Scope("singleton")
public class TeamsService {

	@Autowired
	private TeamRepository teamRepository;
	
	public Teams registerOrUpdateTeam(Teams team) {
		team = teamRepository.save(team);
		System.out.println("Team Registered "+team);
		return team;
	}
	
	public Object findByTeamno(int teamno) {
		try {
			return teamRepository.findById(teamno).get();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	
//	public void deleteByTeamno(int teamno) {
//		teamRepository.deleteById(teamno);
//	}
}
