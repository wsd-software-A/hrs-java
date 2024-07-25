/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package com.example.hrs.app.reservation;

import java.util.Date;

import com.example.hrs.app.AppException;
import com.example.hrs.app.ManagerFactory;
import com.example.hrs.domain.reservation.ReservationManager;
import com.example.hrs.domain.reservation.ReservationException;
import com.example.hrs.domain.room.RoomManager;
import com.example.hrs.domain.room.RoomException;

/**
 * Control class for Reserve Room
 * 
 */
public class ReserveRoomControl {

	public String makeReservation(Date stayingDate) throws AppException {
		//Permitting only one night so that change amount of availableQty is always -1
		int availableQtyOfChange = -1;
		try {
			//Update number of available rooms
			RoomManager roomManager = getRoomManager();
			roomManager.updateRoomAvailableQty(stayingDate, availableQtyOfChange);

			//Create reservation
			ReservationManager reservationManager = getReservationManager();
			String reservationNumber = reservationManager.createReservation(stayingDate);
			return reservationNumber;
		}
		catch (RoomException e) {
			AppException exception = new AppException("Failed to reserve", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
		catch (ReservationException e) {
			AppException exception = new AppException("Failed to reserve", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
	}

	private RoomManager getRoomManager() {
		return ManagerFactory.getInstance().getRoomManager();
	}

	private ReservationManager getReservationManager() {
		return ManagerFactory.getInstance().getReservationManager();
	}
}
