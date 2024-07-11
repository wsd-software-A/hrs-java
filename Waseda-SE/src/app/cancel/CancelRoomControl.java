package app.cancel;

import java.util.Date;

import app.AppException;
import app.ManagerFactory;
import domain.payment.PaymentManager;
import domain.payment.PaymentException;
import domain.reservation.ReservationManager;
import domain.reservation.ReservationException;
import domain.room.RoomManager;
import domain.room.RoomException;

/**
 * Control class for Cancel Customer
 * 
 */
public class CancelRoomControl {

   public String cancel(String reservationNumber) throws AppException {
      try {
         // Permitting only one night so that change amount of availableQty is always -1
         int availableQtyOfChange = -1;
         try {
            
            // Update number of available rooms
            RoomManager roomManager = getRoomManager();
            roomManager.deleteRoomAvailableQty(stayingDate, availableQtyOfChange);

            // Create reservation
            ReservationManager reservationManager = getReservationManager();
            Date stayingDate = reservation.getStayingDate();

            reservationManager.

         } catch (RoomException e) {
            AppException exception = new AppException("Failed to reserve", e);
            exception.getDetailMessages().add(e.getMessage());
            exception.getDetailMessages().addAll(e.getDetailMessages());
            throw exception;
         } catch (ReservationException e) {
            AppException exception = new AppException("Failed to reserve", e);
            exception.getDetailMessages().add(e.getMessage());
            exception.getDetailMessages().addAll(e.getDetailMessages());
            throw exception;
         }
      } catch (ReservationException e) {
         AppException exception = new AppException("Failed to check-in", e);
         exception.getDetailMessages().add(e.getMessage());
         exception.getDetailMessages().addAll(e.getDetailMessages());
         throw exception;

      } catch (RoomException e) {
         AppException exception = new AppException("Failed to check-in", e);
         exception.getDetailMessages().add(e.getMessage());
         exception.getDetailMessages().addAll(e.getDetailMessages());
         throw exception;
      } catch (PaymentException e) {
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
