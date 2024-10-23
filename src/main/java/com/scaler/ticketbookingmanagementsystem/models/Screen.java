package com.scaler.ticketbookingmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen extends BaseModel{
    private String name;
    private List<Feature> feature;
    private List<Seat> seats;

}
