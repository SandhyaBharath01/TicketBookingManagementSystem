package com.scaler.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="cities")
public class City extends BaseModel{
    private String name;

    @OneToMany
    @JoinColumn(name = "cityId")
    private List<Theater> theaters;

//    1                  M
//    City ---------  Theater => 1:M
//    1                 1
}
