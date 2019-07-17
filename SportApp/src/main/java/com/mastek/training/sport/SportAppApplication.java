package com.mastek.training.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mastek.training.sport.apis.PlayerService;
import com.mastek.training.sport.entities.Player;

@SpringBootApplication
public class SportAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportAppApplication.class, args);
	}

}
