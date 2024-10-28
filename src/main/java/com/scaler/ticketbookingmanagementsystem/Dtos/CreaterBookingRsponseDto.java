package com.scaler.ticketbookingmanagementsystem.Dtos;

import com.scaler.ticketbookingmanagementsystem.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreaterBookingRsponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}
