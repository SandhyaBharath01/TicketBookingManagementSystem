package com.scaler.ticketbookingmanagementsystem.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.script.ScriptEngine;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
    @ElementCollection
    private List<Feature> features;
}
