package com.scaler.bookmyshowjune2023.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seatList;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> featureList;

}
