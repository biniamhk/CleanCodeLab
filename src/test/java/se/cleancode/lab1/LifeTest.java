package se.cleancode.lab1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LifeTest {




    Board board;
    Board newGenerationBoard;
    Life life;
    MathRandomImplementation mathRandomImplementation;
    DummyMathRandom dummyMathRandom;



    @Test
    public void testInitializeBoardWithDummyMathRandomMethod(){
        dummyMathRandom= new DummyMathRandom();
        life = new Life(dummyMathRandom);
        board = new Board(4,5);
        int expected= board.getRows()* board.getColumns();
        int result= life.initializeBoard(board);
        assertEquals(expected,result);


    }
    @BeforeEach
    public void setUp() {
        mathRandomImplementation = Mockito.mock(MathRandomImplementation.class);
        life = new Life(mathRandomImplementation);

    }

    @Test
    public void testInitializeBoardWithMockito() {
        board = new Board(4, 4);
        int numberChoice = 0;

        Mockito.when(mathRandomImplementation.mathRandom(3)).thenReturn(numberChoice);
        int expected = board.getRows()* board.getColumns();
        int result=life.initializeBoard(board);

        assertEquals(expected,result);

    }
    @Test
    void checkIfValuesAreAssignedToCells() {
        board = new Board(3, 4);
        life = new Life(mathRandomImplementation);
        int livingCells = life.initializeBoard(board);

        assertTrue(livingCells > 0);

    }

    @Test
    void checkNumberOfLivingNeighbours() {
        board = new Board(3, 4);
        life = new Life();

        board.setAlive(1, 1);
        board.setAlive(0, 0);
        board.setAlive(0, 1);
        board.setAlive(2, 2);
        board.setAlive(1, 2);

        assertEquals(4, life.countNeighbours(1, 1, board));

    }

    @Test
    void checkingEdgeCases() {
        board = new Board(3, 4);
        life = new Life();


        board.setAlive(0, 1);
        board.setAlive(1, 0);
        board.setAlive(1, 1);

        assertTrue(life.checkEdgeCases(board,0,3));
        assertFalse(life.checkEdgeCases(board,-1,-1));
        assertFalse(life.checkEdgeCases(board,3,4));

    }

    @Test
    void calculateNextGenerationForLivingCellWithLessThanTwoNeighbours() {

        board = new Board(3, 4);
        newGenerationBoard = new Board(3, 4);
        life = new Life();
        board.setAlive(0, 0);
        board.setAlive(0, 1);
        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(0, newGenerationBoard.getValueAtPosition(0, 0));

    }

    @Test
    void calculateNextGenerationForLivingCellWithMoreThanThreeLivingNeighbours() {

        board = new Board(3, 4);
        newGenerationBoard = new Board(3, 4);
        life = new Life();
        board.setAlive(1, 1);
        board.setAlive(0, 0);
        board.setAlive(0, 1);
        board.setAlive(1, 0);
        board.setAlive(1, 2);
        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(0, newGenerationBoard.getValueAtPosition(1, 1));

    }

    @Test
    void calculateNextGenerationForLivingCellWithThreeOrTwoLivingNeighbours() {

        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life();
        board.setAlive(1, 1);
        board.setAlive(0, 0);
        board.setAlive(0, 1);
        board.setAlive(1, 0);

        board.setAlive(3, 4);
        board.setAlive(2, 4);
        board.setAlive(3, 3);

        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(1, newGenerationBoard.getValueAtPosition(1, 1));

        assertEquals(1, newGenerationBoard.getValueAtPosition(3, 4));

    }

    @Test
    void calculateNextGenerationForDeadCellWithThreeLivingNeighbours() {

        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life();
        board.setDead(1, 1);
        board.setAlive(0, 0);
        board.setAlive(0, 1);
        board.setAlive(1, 0);

        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(1, newGenerationBoard.getValueAtPosition(1, 1));

    }

    @Test
    void calculateNextGenerationForDeadCellWithNoThreeLivingNeighbours() {

        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life();
        board.setDead(1, 1);
        board.setAlive(0, 0);
        board.setAlive(0, 1);


        board.setDead(3, 4);
        board.setAlive(2, 4);
        board.setAlive(3, 3);
        board.setAlive(3, 5);
        board.setAlive(4, 4);

        board.setDead(0, 4);

        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(0, newGenerationBoard.getValueAtPosition(1, 1));
        assertEquals(0, newGenerationBoard.getValueAtPosition(3, 4));
        assertEquals(0, newGenerationBoard.getValueAtPosition(0, 4));


    }

    @Test
    void checkIfValuesTransferredBetweenBoards() {
        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life(mathRandomImplementation);
        life.initializeBoard(board);
        life.calculateNextGeneration(board, newGenerationBoard);
        life.transferNewToCurrent(board, newGenerationBoard);


        assertTrue(Arrays.deepEquals(board.getBoard(), newGenerationBoard.getBoard()));


    }

    @Test
    void checkDisplayBoard() {

        board = new Board(3, 3);
        life = new Life();

        board.setAlive(0, 0);
        board.setAlive(0, 2);
        board.setAlive(1, 1);
        board.setAlive(2, 0);
        board.setAlive(2, 2);
        assertEquals("*" + " " + "." + " " + "*" + " " + "\n" + "." + " " + "*" + " " + "." + " " + "\n" + "*" + " " + "." + " " + "*" + " "
                , Arrays.deepToString(life.displayBoard(board)).replace("], [", "\n").replace("[", "")
                        .replace("]", "").replace(", ", ""));
        System.out.println();
        assertEquals(Arrays.deepToString(board.getBoard()).replace("1", "*" + " ").replace("0", "." + " ")
                , Arrays.deepToString(life.displayBoard(board)));

    }


}
