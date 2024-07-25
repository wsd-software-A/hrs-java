package com.example.hrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
  @GetMapping("/")
  public String home(Model model) {
    return "home";
  }

  @GetMapping("/checkin")
  public String checkin(Model model) {
    return "checkin";
  }

  @GetMapping("/checkout")
  public String checkout(Model model) {
    return "checkout";
  }

  @GetMapping("/reservation")
  public String reservation(Model model) {
    return "reservation";
  }
  @GetMapping("/cancel")
  public String cancel(Model model) {
    return "cancel";
  }
}
