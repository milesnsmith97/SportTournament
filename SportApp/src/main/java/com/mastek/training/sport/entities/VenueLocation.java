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
@Table(name="JPA_VENUE_LOCATION")
public class VenueLocation {
	@Value("-1")
	private int venueno;
	@Value("Default Venue")
	private String venueName;
	@Value("Default Location")
	private String location;
	
	public VenueLocation() {
		System.out.println("Venue Created");
	}
	
	@Id
	@Column(name="venue_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getVenueno() {
		return venueno;
	}

	public void setVenueno(int venueno) {
		this.venueno = venueno;
	}

	@Column(name="venue_name",nullable=false,length=45)
	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	@Column(name="venue_location",nullable=false,length=45)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "VenueLocation [venueno=" + venueno 
				+ ", venueName=" + venueName 
				+ ", location=" + location 
				+ "]";
	}
	
	

}
