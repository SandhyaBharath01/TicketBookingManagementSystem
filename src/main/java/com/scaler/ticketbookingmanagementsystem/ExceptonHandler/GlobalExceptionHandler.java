package com.scaler.ticketbookingmanagementsystem.ExceptonHandler;

import com.scaler.ticketbookingmanagementsystem.Exceptions.ShowSeatNotfoundException;
import com.scaler.ticketbookingmanagementsystem.Exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException(){
        System.out.println("User not found");
    }
    @ExceptionHandler(ShowSeatNotfoundException.class)
    public void handleShowSeatNotFoundException(){
        System.out.println("Show with seat id not found");
    }
}
