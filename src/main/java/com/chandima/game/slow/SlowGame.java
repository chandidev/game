package com.chandima.game.slow;

import com.chandima.game.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlowGame {

    private static List<Integer> seats;
    private static List<Integer> removedList = new ArrayList<>();
    private static int lastEvicted = 0;

    public static Result play(int n, int k) {

        seats = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
        Integer winner = null;

        if(k > 0) {
            while(seats.size() > 1) {
                int currentStudent = lastEvicted;
                int seatsCount = seats.size();
                for(int count =0 ; count < k; count++) {
                    if (currentStudent == seatsCount) {
                        currentStudent = 0;
                    }
                    currentStudent ++;
                }
                lastEvicted = currentStudent;
                removedList.add(seats.get(lastEvicted - 1));
                seats.remove(lastEvicted - 1);
                //adjust the position
                lastEvicted--;
            }
            winner = seats.size() > 0 && k > 0 ? seats.get(0): null;

        }
        Result result = new Result(winner, removedList);
        return result;

    }



}
