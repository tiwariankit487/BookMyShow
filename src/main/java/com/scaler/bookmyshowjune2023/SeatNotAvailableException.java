package com.scaler.bookmyshowjune2023;

public class SeatNotAvailableException extends Exception{
    public SeatNotAvailableException(String message){
        super(message);
    }
}
