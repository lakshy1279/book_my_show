package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatType extends BaseModel {
    private String name;
    private Theatre theatre;
}
