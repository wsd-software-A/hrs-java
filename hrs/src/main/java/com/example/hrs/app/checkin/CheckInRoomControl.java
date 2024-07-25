/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package com.example.hrs.app.checkin;

import java.util.Date;

import com.example.hrs.app.AppException;
import com.example.hrs.app.ManagerFactory;
import com.example.hrs.domain.payment.PaymentManager;
import com.example.hrs.domain.payment.PaymentException;
import com.example.hrs.domain.reservation.ReservationManager;
import com.example.hrs.domain.reservation.ReservationException;
import com.example.hrs.domain.room.RoomManager;
import com.example.hrs.domain.room.RoomException;

/**
 * Control class for Check-in Customer
 * 
 */
public class CheckInRoomControl {

	public String checkIn(String reservationNumber) throws AppException {
		try {
			//Consume reservation
			ReservationManager reservationManager = getReservationManager();
			Date stayingDate = reservationManager.consumeReservation(reservationNumber);

			//Assign room
			RoomManager roomManager = getRoomManager();
			String roomNumber = roomManager.assignCustomer(stayingDate);

			//Create payment
			PaymentManager paymentManager = getPaymentManager();
			paymentManager.createPayment(stayingDate, roomNumber);

			return roomNumber;
		}
		catch (ReservationException e) {
			AppException exception = new AppException("Failed to check-in", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
		catch (RoomException e) {
			AppException exception = new AppException("Failed to check-in", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
		catch (PaymentException e) {
			AppException exception = new AppException("Failed to check-in", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
	}

	private ReservationManager getReservationManager() {
		return ManagerFactory.getInstance().getReservationManager();
	}

	private RoomManager getRoomManager() {
		return ManagerFactory.getInstance().getRoomManager();
	}

	private PaymentManager getPaymentManager() {
		return ManagerFactory.getInstance().getPaymentManager();
	}
}
