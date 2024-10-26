package com.scaler.ticketbookingmanagementsystem.Exceptions;

import com.scaler.ticketbookingmanagementsystem.Repositories.ShowSeatrepository;

public class ShowSeatNotfoundException extends Exception{
    public ShowSeatNotfoundException(String message){
        super(message);
    }
}
