package com.scaler.bookmyshowjune2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Seats")
public class Seat extends BaseModel {
    private int seatNumber;
    private int rowNum;
    private int columnNum;

    @ManyToOne
    private SeatType seatType;
}
