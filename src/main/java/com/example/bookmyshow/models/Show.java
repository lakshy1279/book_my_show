package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class Show extends BaseModel{
    private Movie movie;
    private Date startTime;
    private Integer duration;
    private Auditorium auditorium;
    private List<ShowSeat> seats;
    private List<ShowSeatType> showSeatTypes;
    private Language language;
}
