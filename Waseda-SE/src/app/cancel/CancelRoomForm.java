package app.cancel;

import app.AppException;

public class CancelRoomForm {
   private CancelRoomControl checkOutRoomControl = new CancelRoomControl();

   private String reservationNumber;

   private CancelRoomControl getCheckOutRoomControl() {
      return checkOutRoomControl;
   }

   public void cancel() throws AppException {
      CancelRoomControl cancelRoomControl = getCheckOutRoomControl();
      cancelRoomControl.cancel(reservationNumber);
   }

   public String getRreservationNumber() {
      return reservationNumber;
   }

   public void setReservationNumber(String reservationNumber) {
      this.reservationNumber = reservationNumber;
   }

}