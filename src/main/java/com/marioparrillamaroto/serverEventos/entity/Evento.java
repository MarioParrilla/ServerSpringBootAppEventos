package com.marioparrillamaroto.serverEventos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 8075692721216543588L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventID;
	
	@Column(nullable = false, length = 15)
	private String eventName;
	
	@Column(nullable = false)
	private LocalDateTime startTime;
	
	@Column(nullable = false)
	private LocalDateTime endTime;
	
	@Column(nullable = false)
	private Boolean available;

	@Column(nullable = false)
	private Boolean eventPreference;

	@Column(length = 100)
	private String coordinates;
	
	@Column(length = 100)
	private String videomeeting;
	
	@ManyToOne
	private Usuario userOwner;
	
	@ManyToOne
	private Usuario userSummoner;

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = LocalDateTime.parse(startTime);
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime =  LocalDateTime.parse(endTime);
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Boolean getEventPreference() {
		return eventPreference;
	}

	public void setEventPreference(Boolean eventPreference) {
		this.eventPreference = eventPreference;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getVideomeeting() {
		return videomeeting;
	}

	public void setVideomeeting(String videomeeting) {
		this.videomeeting = videomeeting;
	}

	public Usuario getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(Usuario userOwner) {
		this.userOwner = userOwner;
	}

	public Usuario getUserSummoner() {
		return userSummoner;
	}

	public void setUserSummoner(Usuario userSummoner) {
		this.userSummoner = userSummoner;
	}
	
	
}
