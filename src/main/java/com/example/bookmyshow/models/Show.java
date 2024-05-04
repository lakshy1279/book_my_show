package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class Show extends BaseModel{
    private String showName;
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private List<ShowSeat> seats;
    private List<ShowSeatType> showSeatTypes;
    private Language language;
}
