package com.Ecommerce.Ecommerce.application.controller;


import com.Ecommerce.Ecommerce.application.Service.UserService;
import com.Ecommerce.Ecommerce.domain.model.User.Role;
import com.Ecommerce.Ecommerce.domain.model.User.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/getSampleUser")
    public ResponseEntity<User> getUser(){
        User user=new User();
        user.setUsername("test");
        user.setRole(Role.USER);
        user.setEmail("test@gmail.com");
        user.setPhone("123456");
        user.setId(new UUID(23,23));

        return  ResponseEntity.ok(user);
    }
}
