package com.example.bookmyshow.services;

import com.example.bookmyshow.exception.SeatsUnavailableException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositiory.ShowSeatRepositiory;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    ShowSeatRepositiory showSeatRepositiory;
    public BookingService() {
        this.showSeatRepositiory = new ShowSeatRepositiory();
    }
    public Booking bookTicket(User bookedBy, List<Long> showSeatsId, Show show) throws SeatsUnavailableException {
        // first take lock over the seats
        //
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

        for(ShowSeat showSeat : currentShowSeats) {
            showSeatRepositiory.unlockShowSeat(showSeat.getId());
        }



        return null;
    }
}
