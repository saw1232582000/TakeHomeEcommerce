package com.Ecommerce.Ecommerce.application.Service;

import com.Ecommerce.Ecommerce.application.dto.authentication.AuthenticationResponse;
import com.Ecommerce.Ecommerce.application.dto.login.LoginDto;
import com.Ecommerce.Ecommerce.application.dto.register.RegisterDto;
import com.Ecommerce.Ecommerce.domain.model.User.User;
import com.Ecommerce.Ecommerce.domain.repository.User.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EntityManager entityManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.entityManager = entityManager;
    }

    public AuthenticationResponse register(RegisterDto request){
        User user=new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setPhone(request.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        user=userRepository.save(user);
        String token=jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(LoginDto request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username,
                        request.password
                )
        );

        User user =  userRepository.findByUsername(request.username).orElseThrow(() -> new UsernameNotFoundException("User not found "));
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
    public void clearCache() {

        entityManager.clear();
    }
}
