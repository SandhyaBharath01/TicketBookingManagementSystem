package com.scaler.ticketbookingmanagementsystem.models;

import java.util.List;

public class Theater extends BaseModel{
    private String theaterName;
    private String theaterAddress;
    private List<Screen> screens;
    private City city;
}
