package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;
    private Theatre theatre;
    private List<Show> shows;
    private ScreenType screenType;
    private List<Seat> seats;
}
