package com.scaler.ticketbookingmanagementsystem.Dtos;

import com.scaler.ticketbookingmanagementsystem.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    private List<Long> showSeatIds;
    private Long userId;
}
