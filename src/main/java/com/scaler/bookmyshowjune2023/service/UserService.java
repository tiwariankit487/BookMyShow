package com.scaler.bookmyshowjune2023.service;

import com.scaler.bookmyshowjune2023.repositories.UserRepository;
import com.scaler.bookmyshowjune2023.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   private UserRepository userRepository;

   @Autowired
   public UserService(UserRepository userRepository){
       this.userRepository = userRepository;
   }
    public User signupUser(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));

        User savedUser=userRepository.save(user);
        return savedUser;
    }
}
