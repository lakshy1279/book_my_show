package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    private List<ShowSeat> showSeats;
    private double amount;
    private Show show;
    private BookingStatus status;
    private User bookedby;
    private List<Payment> payments;
}
