The Application was created with spring boot to get started quickly with the project structure and  unit test framework. 
but application uses only pure java classes.

The application has two implementations of the game for comparison. The main implementation is in com.chandima.game package.
A slow inefficient single class implementation has been created in com.chandima.game.slow package.
Both applications provides the same results but the one in game package is efficient and more structured.

main application has only one loop. the evicted student is determined by the code in Seats.java classs
This uses just integer division with and relies on the remainder.
the looping will happen n times.
The entry class with static method is Game.run(n,k)

The slow application version uses FOR loop to loop through the student counting and an external WHILE loop to loop through each round.
In the slow implementation while loop size reduces with each run but for loop remains constant (k).


unit tests cover edge cases, normal run cases and extremely large numbers.


there is an additional unit test which has been commented out, which outputs the time comparison between the slow and fast implementations.
when used with small numbers there is no difference, but with large numbers it will be very significant.
in a typical run with 

student number : 99999

counting       : 99999

when run with those inputs, comparison times:

fast run timetaken: 256  milliseconds

slow run timetaken: 3660 milliseconds


**further improvements to fast algorithm**
In the Main game (fast version) there are two ternary (inline if) statements for each loop
But most of the time it will be evaluated as true. 
therefore runtime performance can be further improved if try cache block is used around 
`int elementValue = seats.get(lastEvictedPosition);` statement. 
when it fails with IndexOutofBoundException after caching, corrective action can be done and continue.

