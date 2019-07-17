package com.mastek.training.sport.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA_TEAM")
public class Teams {
	@Value("-1")
	private int teamno;
	@Value("Default Team")
	private String name;
	@Value("Default Nationality")
	private String nationality;
	
	public Teams() {
		System.out.println("Team Created");
	}

	
	@Id
	@Column(name="team_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTeamno() {
		return teamno;
	}

	public void setTeamno(int teamno) {
		this.teamno = teamno;
	}

	@Column(name="team_name",nullable=false,length=45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	@Override
	public String toString() {
		return "Teams [teamno=" + teamno 
				+ ", name=" + name 
				+ ", nationality=" + nationality 
				+ "]";
	}
	
	
}
