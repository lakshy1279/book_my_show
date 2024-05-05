package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.Show;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryShowRepositiory implements ShowRepositiory{

    Map<String, Show> shows = new HashMap<>();
    @Override
    public Show getShowById(Long id) {
        if (shows.containsKey(id.toString())) {
            return shows.get(id.toString());
        }
        return null;
    }
}
