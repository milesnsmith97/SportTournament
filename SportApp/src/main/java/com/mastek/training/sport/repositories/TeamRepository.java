package com.mastek.training.sport.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mastek.training.sport.entities.Teams;

public interface TeamRepository  extends CrudRepository<Teams, Integer>{

}
