package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.Show;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepositiory {

    Show getShowById(Long id);
}
