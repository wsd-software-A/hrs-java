package com.example.hrs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CancelController {
  @GetMapping("/cancel")
  public String index(Model model) {
    return "cancel";
  }
}
