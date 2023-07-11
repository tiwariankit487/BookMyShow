package com.scaler.bookmyshowjune2023.controllers;

import com.scaler.bookmyshowjune2023.dtos.BookingTicketRequestDto;
import com.scaler.bookmyshowjune2023.dtos.BookingTicketResponseDto;
import com.scaler.bookmyshowjune2023.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.TimeoutException;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookingTicketResponseDto bookTicket(BookingTicketRequestDto bookingTicketRequestDto) {
        BookingTicketResponseDto bookingTicketResponseDto = new BookingTicketResponseDto();
        return null;
    }
}
