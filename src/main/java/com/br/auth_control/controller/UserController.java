package com.br.auth_control.controller;

import com.br.auth_control.model.User;
import com.br.auth_control.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    List<User> findAll(){
        return  this.userService.findAll();
    }

    @PostMapping
    User createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }
}
