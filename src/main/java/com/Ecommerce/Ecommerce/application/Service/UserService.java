package com.Ecommerce.Ecommerce.application.Service;


import com.Ecommerce.Ecommerce.domain.modal.User.User;

import com.Ecommerce.Ecommerce.domain.repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createUser(){
        User newUser=new User();
        newUser.setPassword("123456");
        newUser.setEmail("saw@gmail.com");
        newUser.setUsername("saw");
        return this.userRepository.save(newUser);
    }

    public User getUser(Long id){
        return this.userRepository.getReferenceById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
