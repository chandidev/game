package com.chandima.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seats {

    List<Integer> seats = new ArrayList<Integer>();
    int lastEvictedPosition = 0;

    public Seats(int total) {
        seats = IntStream.range(1, total + 1).boxed().collect(Collectors.toList());
    }

    public Integer getStudent(int k) {
        int total = seats.size();
        lastEvictedPosition = (k % total) + lastEvictedPosition -1;
        lastEvictedPosition = lastEvictedPosition >= total ? lastEvictedPosition - total : lastEvictedPosition;
        lastEvictedPosition = lastEvictedPosition == -1 ? total -1 : lastEvictedPosition;
        int elementValue = seats.get(lastEvictedPosition);
        seats.remove(lastEvictedPosition);
        return elementValue;
    }

    public int size() {
        return seats.size();
    }

    public Integer getWinner() {
        return seats.size() == 1 ? seats.get(0) : null;
    }

}
