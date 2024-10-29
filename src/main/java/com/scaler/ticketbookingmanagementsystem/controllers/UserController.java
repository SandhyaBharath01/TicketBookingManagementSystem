package com.scaler.ticketbookingmanagementsystem.controllers;

import com.scaler.ticketbookingmanagementsystem.Dtos.LoginRequestDto;
import com.scaler.ticketbookingmanagementsystem.Dtos.ResponseStatus;
import com.scaler.ticketbookingmanagementsystem.Dtos.UserSignupRequestDto;
import com.scaler.ticketbookingmanagementsystem.Dtos.UserSignupResponseDto;
import com.scaler.ticketbookingmanagementsystem.models.User;
import com.scaler.ticketbookingmanagementsystem.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/signup")
    public UserSignupResponseDto signup(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        User user = userService.signup(
                userSignupRequestDto.getName(),
                userSignupRequestDto.getEmail(),
                userSignupRequestDto.getPassword()
        );
        UserSignupResponseDto responseDto = new UserSignupResponseDto();
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setName(user.getUsername());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
    @GetMapping("/login")
    public ResponseStatus login(@RequestBody LoginRequestDto requestDto){
        return userService.login(requestDto.getEmail(),
                requestDto.getPassword());
    }
}
