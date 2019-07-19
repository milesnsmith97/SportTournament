package com.mastek.training.sport.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component


@Scope("prototype")
@Entity
@Table(name="JPA_TEAM")
@XmlRootElement
public class Teams {
	@Value("-1")
	private int teamno;
	
	@Value("Default Team")
	@FormParam("name")
	private String name;
	
	@Value("Default Nationality")
	@FormParam("nationality")
	private String nationality;
	
	public Teams() {
		System.out.println("Team Created");
	}

	private Set<Player> members = new HashSet<>();
	
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


	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="currentTeam")
	@XmlTransient
	public Set<Player> getMembers() {
		return members;
	}

	public void setMembers(Set<Player> members) {
		this.members = members;
	}
	
	@Override
	public String toString() {
		return "Teams [teamno=" + teamno 
				+ ", name=" + name 
				+ ", nationality=" + nationality 
				+ "]";
	}
	
	
}
