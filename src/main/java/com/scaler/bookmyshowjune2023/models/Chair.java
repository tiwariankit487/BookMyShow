package com.scaler.bookmyshowjune2023.models;

import jakarta.persistence.ManyToOne;

public class Chair extends BaseModel{
    private String seatNumber;
    private int rows;
    private int cols;
    @ManyToOne
    private SeatType seatType;
}
