package com.mastek.training.sport.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.sport.entities.Player;
import com.mastek.training.sport.repositories.PlayerRepository;

@Component
@Scope("singleton")
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public PlayerService() {
		System.out.println("Player Service Created");
	}
	
	public Player registerOrUpdatePlayer(Player play) {
		play = playerRepository.save(play);
		System.out.println("Player Registered "+play);
		return play;
	}
	
	public Player findByPlayerno(int playerno) {
		try {
			return playerRepository.findById(playerno).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteByPlayerno(int playerno) {
		playerRepository.deleteById(playerno);
	}
}
