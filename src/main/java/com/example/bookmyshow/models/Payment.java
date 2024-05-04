package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseModel{
  private double amount;
  private PaymentMethod method;
  private PaymentStatus status;
  private Booking booking;
  private Date timeOfPayment;
}
