package com.chandima.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static Result run(int n, int k) {
        Seats seats = new Seats(n);
        List<Integer> evictedStudents = new ArrayList<>();

        if(k > 0) {
            while(seats.size() > 1) {
                evictedStudents.add(seats.getStudent(k));
            }
        }
        return new Result(seats.getWinner(), evictedStudents);
    }
}
