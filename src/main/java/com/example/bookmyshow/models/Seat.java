package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
    private String seatNo;
    private SeatType seatType;
}
