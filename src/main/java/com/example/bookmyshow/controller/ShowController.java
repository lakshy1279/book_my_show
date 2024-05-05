package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.ShowRequestDto;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.services.ShowService;
import org.springframework.stereotype.Controller;

@Controller
public class ShowController {

    ShowService showService;
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public Show createShow(ShowRequestDto request)
    {
          return showService.createShow(request);
    }
}
