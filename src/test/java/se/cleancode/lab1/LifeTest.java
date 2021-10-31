package se.cleancode.lab1;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LifeTest {

    //Create a two-dimensional grid with input cell
    //Iinitialize the grid using math-random method

    Board board;
    Life life =new Life();
    @Test
    void checkIfValuesAreAssignedToCells() {
        board = new Board(3, 4);
        int livingCells = life.initializeBoard(board);

        assertTrue(livingCells>0);

    }

}
