package com.scaler.bookmyshowjune2023.service;

import com.scaler.bookmyshowjune2023.repositories.*;
import com.scaler.bookmyshowjune2023.InvalidArgumentException;
import com.scaler.bookmyshowjune2023.SeatNotAvailableException;
import com.scaler.bookmyshowjune2023.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(SeatRepository seatRepository, ShowSeatRepository showSeatRepository, ShowRepository showRepository, UserRepository userRepository, TicketRepository ticketRepository){
        this.seatRepository=seatRepository;
        this.showSeatRepository=showSeatRepository;
        this.showRepository=showRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    public Ticket bookTicket( List<Long> seatIds,
        Long userId,
       Long UserId,Long showId) throws Exception {

List<Seat> seats = seatRepository.findAllById(seatIds);

Optional<Show> showOptional = showRepository.findById(showId);
if(showOptional.isEmpty()){
    throw new InvalidArgumentException(
            "show by "+ showId +"doesn't exist"
    );
}

        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats,showOptional.get());

for(ShowSeat showSeat:showSeats){
    if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) || showSeat.getShowSeatStatus().equals(ShowSeatStatus.LOCKED) && new Date().getTime()-showSeat.getLockedAt().getTime()>15){
        throw new SeatNotAvailableException("seat not avaialable");
    }
}
List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
           savedShowSeats.add(showSeatRepository.save(showSeat));
        }
Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new InvalidArgumentException(
                "user doesn't exist"
            );
        };
        Ticket ticket = new Ticket();
        ticket.setUser(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setShow(showOptional.get());
        ticket.setSeatList(seats);
        ticket.setAmount(0);
        ticket.setTimeOfBooking(new Date());
Ticket savedTicket = ticketRepository.save(ticket);
return savedTicket;

// for seatids get the corresponding showseats
        //check the status of seat
        //a. every seat is available
        //b. lock all the seats(seat status locked)
        //c. release lock
        //d. create ticket object and return
        // e. some of seats are not available
        //f. throw exception
        // getShowSeatsForSeats(seats)
        // getSeatsForIds(ids)
    }
}
