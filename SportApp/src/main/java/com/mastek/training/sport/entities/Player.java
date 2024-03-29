package com.mastek.training.sport.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Component


@Scope("prototype")
@Entity
@Table(name="JPA_PLAYER")
@XmlRootElement
public class Player implements Serializable {

	@Value("-1")
	private int playerno;
	
	@Value("Default Player")
	@FormParam("name")
	private String name;
	
	@Value("100.0")
	@FormParam("salary")
	private double salary;
	
	
	// Each player belongs to a team
	private Teams currentTeam;
	
	@ManyToOne
	@JoinColumn(name="FK_Team_id")
	public Teams getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Teams currentTeam) {
		this.currentTeam = currentTeam;
	}

	public Player() {
		System.out.println("Player Created");
	}
	

	@Id
	@Column(name="player_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPlayerno() {
		return playerno;
	}

	public void setPlayerno(int playerno) {
		this.playerno = playerno;
	}

	@Column(name="player_name",nullable=false,length=45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Player [playerno=" + playerno 
				+ ", name=" + name 
				+ ", salary=" + salary 
//				+ ", currentTeam=" + currentTeam
				+ "]";
	}

	
	
	

}
