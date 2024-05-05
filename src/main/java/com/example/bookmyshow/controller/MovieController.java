package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.MovieRequestDto;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.services.MovieService;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {
    MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie createMovie(MovieRequestDto request)
    {
        return movieService.createMovie(request);
    }
}
