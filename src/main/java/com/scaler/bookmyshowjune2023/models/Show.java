package com.scaler.bookmyshowjune2023.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "Shows")
public class Show extends BaseModel{
    @ManyToOne
    private Auditorium auditorium;
    private Date start_time;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne
    private Movie movie;
}
