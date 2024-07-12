package com.example.hrs_demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Reservation {

	public static final String RESERVATION_STATUS_CREATE = "create";

	public static final String RESERVATION_STATUS_CONSUME = "consume";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private String reservationNumber;
	private Date stayingDate;
	private String status;

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Date getStayingDate() {
		return stayingDate;
	}

	public void setStayingDate(Date stayingDate) {
		this.stayingDate = stayingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
