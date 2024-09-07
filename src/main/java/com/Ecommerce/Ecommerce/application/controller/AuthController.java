package com.Ecommerce.Ecommerce.application.controller;


import com.Ecommerce.Ecommerce.application.Service.AuthService;
import com.Ecommerce.Ecommerce.application.dto.authentication.AuthenticationResponse;
import com.Ecommerce.Ecommerce.application.dto.login.LoginDto;
import com.Ecommerce.Ecommerce.application.dto.register.RegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Tag(name = "Auth")
public class AuthController {
    private final AuthService authService;
   // private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            description = "Endpoint for user registration",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterDto registerDto){
        //logger.info(String.valueOf(registerDto));
        return ResponseEntity.ok(this.authService.register(registerDto));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto loginDto){
       // logger.info(String.valueOf(loginDto));
        return ResponseEntity.ok(this.authService.authenticate(loginDto));
    }
}
