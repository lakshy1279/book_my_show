package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.ShowRequestDto;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.repositiory.ShowRepositiory;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    ShowRepositiory showRepositiory;
    public ShowService(ShowRepositiory showRepositiory) {
        this.showRepositiory = showRepositiory;
    }

    public Show createShow(ShowRequestDto request) {

        return showRepositiory.save()
    }
}
