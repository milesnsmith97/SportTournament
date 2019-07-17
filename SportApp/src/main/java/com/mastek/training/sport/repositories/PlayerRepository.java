package com.mastek.training.sport.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mastek.training.sport.entities.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer>{

	
}
