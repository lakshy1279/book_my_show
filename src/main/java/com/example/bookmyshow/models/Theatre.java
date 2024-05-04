package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Theatre extends BaseModel {
  private String name;
  private String location;
  private List<Auditorium> auditoriums;
  private City city;
}
