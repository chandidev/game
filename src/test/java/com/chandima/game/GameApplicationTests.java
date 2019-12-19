package com.chandima.game;

import com.chandima.game.slow.SlowGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest
class GameApplicationTests {



    @Test
    void zeroValuesDoesNotFail(){
        Result result = Game.run(0,0);
        Assertions.assertEquals(new ArrayList<>(), result.getEvicted());
        Assertions.assertEquals(null, result.getWinner());
    }

    @Test
    void zeroStudentsDoesNotFail() {
        Result result = Game.run(0,25);
        Assertions.assertEquals(new ArrayList<>(), result.getEvicted());
        Assertions.assertEquals(null, result.getWinner());
    }

    @Test
    void zeroCountDoesNotFail() {
        Result result = Game.run(25,0);
        Assertions.assertEquals(new ArrayList<>(), result.getEvicted());
        Assertions.assertEquals(null, result.getWinner());
    }

    @Test
    void canDealWithNormalValues() {
        Result result = Game.run(10,15);
        Integer values[] = {5, 1, 9, 10, 4, 3, 8, 7, 2};
        Assertions.assertEquals(Arrays.asList(values), result.getEvicted());
        Assertions.assertEquals(6, result.getWinner());
    }

    @Test
    void canDealWithLargeNumbers() {
        Result result = Game.run(99999,99999);
        Assertions.assertTrue(result.getWinner().intValue() > 0);
        Assertions.assertEquals(99998, result.getEvicted().size());
    }


    /**
     * this test does the performance comparison with the algorithm in the Game and an inefficient implementation of the same run. the changes are significant only when numbers are very large.
     * this also verifies that the two algorithms give the same results.
     * uncomment @Test to run this.
     */
    @Test
    void performancComparison() {
        runGame(99999, 99999, true);
    }



    private void runGame(int studentCount, int numberCount, boolean logDuration) {
        Date start = new Date();
        Result result = Game.run(studentCount,numberCount);
        Date end = new Date();

        if(logDuration) {
            System.out.println("fast run timetaken: " + (end.getTime() - start.getTime()));
        }

        start = new Date();
        Result slowResult = SlowGame.play(studentCount, numberCount);
        end = new Date();

        if(logDuration){
            System.out.println("slow run timetaken: " + (end.getTime() - start.getTime()));
        }

        Assertions.assertEquals(result.getWinner(), slowResult.getWinner());
        Assertions.assertEquals(result.getEvicted(), slowResult.getEvicted());
    }

}
