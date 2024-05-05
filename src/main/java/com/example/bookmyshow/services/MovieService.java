package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.MovieRequestDto;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repositiory.MovieRepositiory;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    MovieRepositiory movieRepositiory;
    public MovieService(MovieRepositiory movieRepositiory) {
        this.movieRepositiory = movieRepositiory;
    }

     public Movie createMovie(MovieRequestDto request) {
         return movieRepositiory.save();
     }
}
