package com.scaler.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String theaterName;
    private String theaterAddress;
    @OneToMany
    private List<Screen> screens;
}
