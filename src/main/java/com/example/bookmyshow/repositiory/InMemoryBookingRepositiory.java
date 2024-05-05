package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.Booking;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryBookingRepositiory implements BookingRepositiory{

    private Map<Long, Booking> bookings = new HashMap<>();
    private Long id = 0L;
    @Override
    public Booking save(Booking booking) {
        booking.setId(id++);
        bookings.put(booking.getId(), booking);
        return booking;
    }
}
