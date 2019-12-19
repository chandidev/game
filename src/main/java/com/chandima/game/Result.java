package com.chandima.game;

import java.util.List;

public class Result {
    Integer winner;
    List<Integer> evicted;

    public Result(Integer winner, List<Integer> evicted) {
        this.winner = winner;
        this.evicted = evicted;
    }

    public Integer getWinner() {
        return winner;
    }

    public List<Integer> getEvicted() {
        return evicted;
    }
}
