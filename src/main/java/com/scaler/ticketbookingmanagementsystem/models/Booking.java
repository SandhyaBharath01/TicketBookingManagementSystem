package com.scaler.ticketbookingmanagementsystem.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

import java.awt.dnd.DropTarget;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends Serializers.Base {
    private User user;
    private List<ShowSeat> showSeats;
    private int amount;
    private List<Payment> payments;
    private Date bookedAt;


}
