package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.BookingRequestDto;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.BookingService;

import java.util.List;

public class BookingController {
    BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking bookTicket(BookingRequestDto requestDto)
    {
        return bookingService.bookTicket(requestDto.getBookedBy(), requestDto.getShowSeatIds(), requestDto.getShow());
    }
}
