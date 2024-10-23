package com.scaler.ticketbookingmanagementsystem.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.awt.dnd.DropTarget;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {

    @ManyToOne
    private User user;

    @OneToMany
    private List<ShowSeat> showSeats;
    private int amount;

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
