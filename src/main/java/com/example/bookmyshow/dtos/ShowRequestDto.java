package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShowRequestDto {
    private Long movieId;
    private Date startTime;
    private Integer duration;
    private Long auditoriumId;
}
