package se.cleancode.lab1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LifeTest {

    //Create a two-dimensional grid with input cell
    //Iinitialize the grid using math-random method

    Board board;
    Life life;

    @Test
    void checkIfValuesAreAssignedToCells() {
        board = new Board(3, 4);
        life= new Life();
        int livingCells = life.initializeBoard(board);

        assertTrue(livingCells > 0);

    }

    @Test
    void checkNumberOfLivingNeighbours() {
        board = new Board(3, 4);
        life= new Life();

        board.setValue(1,1,1);
        board.setValue(0,0,1);
        board.setValue(0,1,1);
        board.setValue(2,2,1);
        board.setValue(1,2,1);

        assertEquals(4,life.countNeighbours(1,1,board));

    }


}
