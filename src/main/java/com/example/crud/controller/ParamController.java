package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamController {

  @GetMapping("/string")
  public String param(
    @RequestParam(
      name = "texto",
      required = false,
      defaultValue = "Algun valor..."
    ) String text,
    Model model
  ) {
    model.addAttribute("resultado", "El texto enviado es: " + text);
    return "params/ver";
  }

  @GetMapping("/mix-params")
  public String param(
    @RequestParam String saludo,
    @RequestParam Integer numero,
    Model model
  ) {
    model.addAttribute(
      "resultado",
      "El saludo es : " + saludo + " y el numero es: " + numero
    );
    return "params/ver";
  }
}
