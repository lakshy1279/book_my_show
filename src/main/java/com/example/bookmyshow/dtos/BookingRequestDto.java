package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDto {
    private List<Long> showSeatIds;
    private User bookedBy;
    Show show;
}
