package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepositiory {
    Booking save(Booking booking);
}
