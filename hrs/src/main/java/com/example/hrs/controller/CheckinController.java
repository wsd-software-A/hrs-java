package com.example.hrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckinController {
  @GetMapping("/checkin")
  public String index(Model model) {
    return "checkin";
  }
}
