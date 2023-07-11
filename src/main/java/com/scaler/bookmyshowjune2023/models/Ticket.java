package com.scaler.bookmyshowjune2023.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private int amount;
    private Date timeOfBooking;
    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;

    @OneToMany
    private List<Payment> paymentList;
    private Date date;

    // in case of refund same seat can be part of multiple tickets
    @ManyToMany
    private List<Seat> seatList;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
