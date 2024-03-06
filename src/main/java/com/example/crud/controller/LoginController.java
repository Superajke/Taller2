package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @Autowired
  private UserService userService;

  @GetMapping({ "/", "login" })
  public String showLoginForm() {
    return "login";
  }

  @PostMapping("/login")
  public String ProcessLogin(
    @RequestParam("email") String email,
    @RequestParam("password") String password,
    Model model
  ) {
    Optional<User> userOptional = userService.getUserByEmail(email);
    if (
      userOptional.isPresent() && userOptional.get().getEmail().equals(email)
    ) {
      if (userOptional.get().getPassword().equals(password)) {
        return "redirect:/app/home/" + email;
      } else {
        model.addAttribute("loginError", "contraseña incorrecta");
        return "login";
      }
    } else {
      model.addAttribute("loginError", "Email incorrecto");
      return "login";
    }
  }
}
