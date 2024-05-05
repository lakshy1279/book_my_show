package com.example.bookmyshow.repositiory;

import com.example.bookmyshow.models.ShowSeat;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ShowSeatRepositiory {
    Map<Long, ShowSeat> showSeatsMap = new ConcurrentHashMap<>();
    Map<Long, Integer> isShowSeatLocked = new ConcurrentHashMap<>();
    public ShowSeat findShowSeatById(long id) {
        if(showSeatsMap.containsKey(id ))
         return showSeatsMap.get(id);
        return null;
    }

    public ShowSeat updateSheet(ShowSeat showSeat) {
        showSeatsMap.put(showSeat.getId(), showSeat);
        return showSeat;
    }

    public boolean takeLockOverShowSeat(Long id) {
        ShowSeat showSeat = showSeatsMap.get(id);
        synchronized (id) {
            if(isShowSeatLocked.containsKey(id))
            {
                if(isShowSeatLocked.get(id).equals(1))
                    return false;
                isShowSeatLocked.put(id, 1);
                return true;
            }
            isShowSeatLocked.put(id, 1);
            return true;
        }
    }

    public void unlockShowSeat(Long id) {
        isShowSeatLocked.put(id, 0);
    }
}
