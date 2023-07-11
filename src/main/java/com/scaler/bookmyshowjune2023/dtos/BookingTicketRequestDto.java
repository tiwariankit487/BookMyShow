package com.scaler.bookmyshowjune2023.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingTicketRequestDto {
private List<Long> seatIds;
private Long userId;

private Long showId;
}
