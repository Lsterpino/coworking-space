package com.grupo05.coworking_space.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grupo05.coworking_space.enums.RoomStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity(name = "ROOM")
@Table(name = "ROOM", schema = "coworking_space")
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "room_id", unique = true)
	private int id;

	@Column(name = "name", nullable = false, length = 20)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "room_status", nullable = false, length = 20)
	private RoomStatus roomStatus;

	@Column(name = "capacity", nullable = false)
	private int capacity;

	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
