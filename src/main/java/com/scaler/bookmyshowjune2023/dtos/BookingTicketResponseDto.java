package com.scaler.bookmyshowjune2023.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookingTicketResponseDto {
    private int amount;
    private Long ticketId;
    private List<String> seatNumber;
    private String auditoriumName;
    private String status;
    private String message;
}
