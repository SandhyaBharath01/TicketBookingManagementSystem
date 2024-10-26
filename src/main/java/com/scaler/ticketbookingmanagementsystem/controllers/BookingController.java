package com.scaler.ticketbookingmanagementsystem.controllers;

import com.scaler.ticketbookingmanagementsystem.Dtos.CreateBookingRequestDto;
import com.scaler.ticketbookingmanagementsystem.Dtos.CreaterBookingRsponseDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    public CreaterBookingRsponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto){
        return null;
    }

}
