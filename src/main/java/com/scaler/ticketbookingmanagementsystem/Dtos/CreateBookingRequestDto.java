package com.scaler.ticketbookingmanagementsystem.Dtos;

import com.scaler.ticketbookingmanagementsystem.models.User;

import java.util.List;

public class CreateBookingRequestDto {
    private User userId;
    private List<Long> showId;
}
