package com.scaler.ticketbookingmanagementsystem.controllers;

import com.scaler.ticketbookingmanagementsystem.Dtos.CreateBookingRequestDto;
import com.scaler.ticketbookingmanagementsystem.Dtos.CreaterBookingRsponseDto;
import com.scaler.ticketbookingmanagementsystem.Dtos.ResponseStatus;
import com.scaler.ticketbookingmanagementsystem.Exceptions.ShowSeatNotfoundException;
import com.scaler.ticketbookingmanagementsystem.Exceptions.UserNotFoundException;
import com.scaler.ticketbookingmanagementsystem.models.Booking;
import com.scaler.ticketbookingmanagementsystem.services.BookingService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    @PostMapping
    private CreaterBookingRsponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto) throws UserNotFoundException, ShowSeatNotfoundException {
        CreaterBookingRsponseDto responseDto = new CreaterBookingRsponseDto();
        Booking booking = null;
        booking = bookingService.createBooking(
                requestDto.getShowSeatIds(),
                requestDto.getUserId()
        );
        responseDto.setBooking(booking);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        if(booking==null){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

}
