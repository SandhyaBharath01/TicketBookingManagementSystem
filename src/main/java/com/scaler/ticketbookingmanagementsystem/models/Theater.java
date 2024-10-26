package com.scaler.ticketbookingmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "theaters")
public class Theater extends BaseModel{
    private String name;
    private String address;
    @OneToMany
    @JoinColumn(name = "theaterId")
    private List<Screen> screens;
}
