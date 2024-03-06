package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(path = "/{userId}")
  public Optional<User> getUserById(@PathVariable("userId") Long userId) {
    return userService.getUserById(userId);
  }

  @GetMapping(path = "/email/{email}")
  public Optional<User> getUserByEmail(@PathVariable("email") String email) {
    return userService.getUserByEmail(email);
  }

  @PostMapping
  public void saveUpdateUser(@RequestBody User user) {
    userService.saveOrUpdate(user);
  }

  @DeleteMapping(path = "/{userId}")
  public void deleteById(@PathVariable("userId") Long userId) {
    userService.deleteUserById(userId);
  }
}
