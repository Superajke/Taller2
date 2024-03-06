package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

  @Autowired
  private UserService userService;

  @GetMapping("/home")
  public String home(Model model) {
    model.addAttribute("nombre", "Usuario");
    model.addAttribute("apellido", "Apellido");
    model.addAttribute("email", "email");
    model.addAttribute("mensaje", "¡Bienvenido al sistema!");
    return "index";
  }

  @GetMapping("/home/{email}")
  public String homeUser(@PathVariable("email") String email, Model model) {
    Optional<User> usuario = userService.getUserByEmail(email);
    System.out.println(usuario);
    model.addAttribute("nombre", usuario.get().getFirstName());
    model.addAttribute("apellido", usuario.get().getLastName());
    model.addAttribute("email", usuario.get().getEmail());
    model.addAttribute("mensaje", "¡Bienvenido al sistema!");
    return "index";
  }
}
