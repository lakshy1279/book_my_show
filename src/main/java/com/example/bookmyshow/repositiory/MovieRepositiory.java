package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieRepositiory {
    Map<Long, Movie> movieMap = new HashMap<>();

    public Movie save(Movie movie){
        movieMap.put(movie.getId(), movie);
        return movie;
    }
}
