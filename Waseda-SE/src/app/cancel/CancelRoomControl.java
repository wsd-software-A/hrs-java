package app.cancel;

import java.util.Date;

import app.AppException;
import app.ManagerFactory;
import domain.reservation.ReservationManager;
import domain.reservation.ReservationException;
import domain.room.RoomManager;
import domain.room.RoomException;

/**
 * Control class for Cancel Customer
 * 
 */
public class CancelRoomControl {

   public void cancel(String reservationNumber) throws AppException {
      try {
         // Permitting only one night so that change amount of availableQty is always -1
         int availableQtyOfChange = -1;
         // Create reservation
         ReservationManager reservationManager = getReservationManager();
         Date stayingDate = reservationManager.consumeReservation(reservationNumber);

         // Update number of available rooms
         RoomManager roomManager = getRoomManager();
         roomManager.deleteRoomAvailableQty(stayingDate, availableQtyOfChange);
      } catch (RoomException e) {
         AppException exception = new AppException("Failed to cancel", e);
         exception.getDetailMessages().add(e.getMessage());
         exception.getDetailMessages().addAll(e.getDetailMessages());
         throw exception;
      } catch (ReservationException e) {
         AppException exception = new AppException("Failed to cancel", e);
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

}