package com.scaler.ticketbookingmanagementsystem.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel{
    String name;
    private List<String> actors;
    private List<String> Languages;

}
