package com.example.bookmyshow.services;

import com.example.bookmyshow.exception.InvalidArgumentException;
import com.example.bookmyshow.exception.SeatsUnavailableException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositiory.BookingRepositiory;
import com.example.bookmyshow.repositiory.ShowRepositiory;
import com.example.bookmyshow.repositiory.ShowSeatRepositiory;
import com.example.bookmyshow.repositiory.UserRepositiory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    ShowSeatRepositiory showSeatRepositiory;
    UserRepositiory userRepositiory;
    ShowRepositiory showRepositiory;
    BookingRepositiory bookingRepositiory;
    public BookingService(ShowSeatRepositiory showSeatRepositiory, UserRepositiory userRepositiory,
                          ShowRepositiory showRepositiory, BookingRepositiory bookingRepositiory) {
        this.userRepositiory = userRepositiory;
        this.showSeatRepositiory = showSeatRepositiory;
        this.showRepositiory = showRepositiory;
        this.bookingRepositiory = bookingRepositiory;
    }
    public Booking bookTicket(Long bookedById, List<Long> showSeatsId, Long showId) throws SeatsUnavailableException, InvalidArgumentException {
        // first take user from userID
        // first take lock over the seats
        Optional<User> userOptional = userRepositiory.getUserById(bookedById);
        if(userOptional.isEmpty()) {
            throw new InvalidArgumentException("User with id:" + bookedById + "doesn't exist");
        }

        Show show = showRepositiory.getShowById(showId);
        List<ShowSeat> currentShowSeats = new ArrayList<>();
        boolean didGetAllLocks = true;
        int count = 0;
        for (Long showSeatId : showSeatsId) {
            boolean didGetLock = showSeatRepositiory.takeLockOverShowSeat(showSeatId);
            if (!didGetLock) {
                didGetAllLocks = false;
                break;
            }
            count++;
        }
        if (!didGetAllLocks) {
            for (int i = 0; i < count; i++) {
                showSeatRepositiory.unlockShowSeat(showSeatsId.get(i));
            }
            throw new SeatsUnavailableException();
        }

        // fetch the current status of those rows
        for(Long showSeatId : showSeatsId) {
             ShowSeat showSeat = showSeatRepositiory.findShowSeatById(showSeatId);
             if(!showSeat.getShowSeatState().equals(ShowSeatState.AVAILABLE)) {
                 for(Long ShowSeatId : showSeatsId) {
                     showSeatRepositiory.unlockShowSeat(ShowSeatId);
                 }
                 throw new SeatsUnavailableException();
             }
             currentShowSeats.add(showSeat);
        }

        List<ShowSeatType> showSeatTypes = show.getShowSeatTypes();

        double amount = 0;
        for(ShowSeat showSeat : currentShowSeats) {
            for(ShowSeatType showSeatType: showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType)) {
                    amount += showSeatType.getPrice();
                }
            }
        }

        Booking booking = new Booking();
        booking.setShowSeats(currentShowSeats);
        booking.setShow(show);
        booking.setAmount(amount);
        booking.setStatus(BookingStatus.PENDING);
        booking.setBookedby(userOptional.get());
        bookingRepositiory.save(booking);

        for(ShowSeat showSeat : currentShowSeats) {
            showSeatRepositiory.unlockShowSeat(showSeat.getId());
        }

        return booking;
    }
}
