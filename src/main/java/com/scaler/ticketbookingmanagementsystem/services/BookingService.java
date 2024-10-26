package com.scaler.ticketbookingmanagementsystem.services;

import com.scaler.ticketbookingmanagementsystem.Exceptions.ShowSeatNotfoundException;
import com.scaler.ticketbookingmanagementsystem.Exceptions.UserNotFoundException;
import com.scaler.ticketbookingmanagementsystem.Repositories.ShowSeatrepository;
import com.scaler.ticketbookingmanagementsystem.Repositories.UserRepository;
import com.scaler.ticketbookingmanagementsystem.models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    public UserRepository userRepository;
    public ShowSeatrepository showSeatrepository;
    public PriceCalculationService priceCalculationService;

    public BookingService(UserRepository userRepository, ShowSeatrepository showSeatrepository, PriceCalculationService priceCalculationService){
        this.userRepository = userRepository;
        this.showSeatrepository = showSeatrepository;
        this.priceCalculationService = priceCalculationService;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(List<Long> showSeatIds, Long userId ) throws UserNotFoundException, ShowSeatNotfoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with userId" +userId + "is not found");
        }
        User user = optionalUser.get();

        List<ShowSeat> showSeats = showSeatrepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.BOOKED)){
                throw new ShowSeatNotfoundException("ShowSeat with show id" + showSeat.getShow().getId() +" and sear with" + showSeat.getSeat().getId()+"is already booked please try another seat");
            }
        }
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            savedShowSeats.add(showSeat);
        }
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculationService.calculatePrice(savedShowSeats));
        return booking;
    }

}
