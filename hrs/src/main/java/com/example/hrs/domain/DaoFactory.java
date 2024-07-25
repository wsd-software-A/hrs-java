/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package com.example.hrs.domain;

import com.example.hrs.domain.payment.PaymentDao;
import com.example.hrs.domain.payment.PaymentSqlDao;
import com.example.hrs.domain.reservation.ReservationDao;
import com.example.hrs.domain.reservation.ReservationSqlDao;
import com.example.hrs.domain.room.AvailableQtyDao;
import com.example.hrs.domain.room.AvailableQtySqlDao;
import com.example.hrs.domain.room.RoomDao;
import com.example.hrs.domain.room.RoomSqlDao;



/**
 * Factory class for generating instance of any Data Object class
 * 
 */
public class DaoFactory {

	private static DaoFactory instance = new DaoFactory();

	private ReservationDao reservationDao = new ReservationSqlDao();

	private RoomDao roomDao = new RoomSqlDao();

	private AvailableQtyDao availableQtyDao = new AvailableQtySqlDao();

	private PaymentDao paymentDao = new PaymentSqlDao();

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		return instance;
	}

	public ReservationDao getReservationDao() {
		return reservationDao;
	}

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public AvailableQtyDao getAvailableQtyDao() {
		return availableQtyDao;
	}

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}
}
