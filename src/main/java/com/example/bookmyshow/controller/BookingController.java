package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.BookingRequestDto;
import com.example.bookmyshow.exception.SeatsUnavailableException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking bookTicket(BookingRequestDto requestDto) throws SeatsUnavailableException {
        return bookingService.bookTicket(requestDto.getBookedById(), requestDto.getShowSeatIds(), requestDto.getShowId());
    }
}
