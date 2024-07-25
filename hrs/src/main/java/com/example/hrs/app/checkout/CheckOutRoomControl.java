/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package com.example.hrs.app.checkout;

import java.util.Date;

import com.example.hrs.app.AppException;
import com.example.hrs.app.ManagerFactory;
import com.example.hrs.domain.payment.PaymentManager;
import com.example.hrs.domain.payment.PaymentException;
import com.example.hrs.domain.room.RoomManager;
import com.example.hrs.domain.room.RoomException;

/*
 *
 * Control class for Check-out Customer
 * 
 */
public class CheckOutRoomControl {

   public void checkOut(String roomNumber) throws AppException {
      try {
         // Assign room
         RoomManager roomManager = getRoomManager();
         Date stayingDate = roomManager.removeCustomer(roomNumber);

         // Create payment
         PaymentManager paymentManager = getPaymentManager();
         paymentManager.consumePayment(stayingDate, roomNumber);

      } catch (RoomException e) {
         AppException exception = new AppException("Failed to check-out", e);
         exception.getDetailMessages().add(e.getMessage());
         exception.getDetailMessages().addAll(e.getDetailMessages());
         throw exception;
      } catch (PaymentException e) {
         AppException exception = new AppException("Failed to check-out", e);
         exception.getDetailMessages().add(e.getMessage());
         exception.getDetailMessages().addAll(e.getDetailMessages());
         throw exception;
      }
   }

   private RoomManager getRoomManager() {
      return ManagerFactory.getInstance().getRoomManager();
   }

   private PaymentManager getPaymentManager() {
      return ManagerFactory.getInstance().getPaymentManager();
   }
}
