package com.scaler.bookmyshowjune2023.controllers;

import com.scaler.bookmyshowjune2023.dtos.SignupUserRequestDto;
import com.scaler.bookmyshowjune2023.dtos.SignupUserResponseDto;
import com.scaler.bookmyshowjune2023.models.User;
import com.scaler.bookmyshowjune2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public SignupUserResponseDto signupUserResponseDto(SignupUserRequestDto signupUserRequestDto){
        User user = userService.signupUser(signupUserRequestDto.getEmail(),signupUserRequestDto.getPassword());
        SignupUserResponseDto signupUserResponseDto = new SignupUserResponseDto();
        signupUserResponseDto.setUserId(user.getId());
        return signupUserResponseDto;
    }
}
