package com.scaler.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel{

    private String seatNumber;
    private int rowValue;
    private int colValue;

    @ManyToOne
    private SeatType seatType;
}
