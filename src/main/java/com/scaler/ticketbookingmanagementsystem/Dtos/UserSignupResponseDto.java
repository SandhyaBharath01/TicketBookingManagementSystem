package com.scaler.ticketbookingmanagementsystem.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupResponseDto {
    private String email;
    private String name;
    private ResponseStatus responseStatus;
}
