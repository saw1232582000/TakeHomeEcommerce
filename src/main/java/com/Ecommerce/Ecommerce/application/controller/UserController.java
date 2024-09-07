package com.Ecommerce.Ecommerce.application.controller;


import com.Ecommerce.Ecommerce.application.Service.UserService;
import com.Ecommerce.Ecommerce.domain.modal.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping("/create")
    public User createUser(){
        return this.userService.createUser();
    }
}
