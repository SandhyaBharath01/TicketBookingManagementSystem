package com.scaler.ticketbookingmanagementsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequestDto {
    private String name;
    private String email;
    private String password;
}
