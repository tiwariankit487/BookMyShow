package com.scaler.bookmyshowjune2023.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;

    private Date lockedAt;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}

