/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package com.example.hrs.app.reservation;

import java.util.Date;

import com.example.hrs.app.AppException;

/**
 * Form class for Reserve Room
 * 
 */
public class ReserveRoomForm {

	private ReserveRoomControl reserveRoomHandler = new ReserveRoomControl();

	private Date stayingDate;

	private ReserveRoomControl getReserveRoomHandler() {
		return reserveRoomHandler;
	}

	public String submitReservation() throws AppException {
		ReserveRoomControl reserveRoomHandler = getReserveRoomHandler();
		return reserveRoomHandler.makeReservation(stayingDate);
	}

	public Date getStayingDate() {
		return stayingDate;
	}

	public void setStayingDate(Date stayingDate) {
		this.stayingDate = stayingDate;
	}

}
