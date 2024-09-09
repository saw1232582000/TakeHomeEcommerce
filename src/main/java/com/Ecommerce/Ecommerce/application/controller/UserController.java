package com.Ecommerce.Ecommerce.application.controller;


import com.Ecommerce.Ecommerce.application.Service.UserService;
import com.Ecommerce.Ecommerce.domain.model.User.Role;
import com.Ecommerce.Ecommerce.domain.model.User.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("users")
@Tag(name = "User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/getMe")
    public ResponseEntity<User> getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }
}
