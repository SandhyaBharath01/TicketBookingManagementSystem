package com.scaler.ticketbookingmanagementsystem.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.dnd.DropTarget;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="bookins")
public class Booking extends BaseModel {

    @ManyToOne
    private User user;

    @OneToMany
    private List<ShowSeat> showSeats;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @OneToMany
    private List<Payment> payments;
    private Date bookedAt;



//    1                  1
//    Booking----------User =>M:1
//    m                   1

//    1               1
//    Booking ----- ShowSeat (S1A1,S2A2,S1A2,S2A2..)
//    m               1

//    1                 m
//    Booking --------- Payment =>1:M
//    1                     1




}
