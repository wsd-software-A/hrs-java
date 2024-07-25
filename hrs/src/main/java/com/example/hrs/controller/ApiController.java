package com.example.hrs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hrs.domain.reservation.Reservation;

@Controller
public class ApiController {
  private static final Logger log = LoggerFactory.getLogger(ApiController.class);
  
  @PostMapping("/api/reservation")
  public String reservationSubmit(@ModelAttribute Reservation reservation, Model model) {
    log.info("getReservationDataが呼ばれました");
    model.addAttribute("reservation", reservation);

    return "reservation";
  }

  @ModelAttribute
  Reservation setReservation() {
    Reservation res = new Reservation();
    return res;
  }
}
