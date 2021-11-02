package se.cleancode.lab1;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Object2DArrayAssert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class LifeTest {


    //Create a two-dimensional grid with input cell
    //Iinitialize the grid using math-random method

    Board board;
    Board newGenerationBoard;
    Life life;

    @Test
    void checkIfValuesAreAssignedToCells() {
        board = new Board(3, 4);
        life = new Life();
        int livingCells = life.initializeBoard(board);

        assertTrue(livingCells > 0);

    }

    @Test
    void checkNumberOfLivingNeighbours() {
        board = new Board(3, 4);
        life = new Life();

        board.setValue(1, 1, 1);
        board.setValue(0, 0, 1);
        board.setValue(0, 1, 1);
        board.setValue(2, 2, 1);
        board.setValue(1, 2, 1);

        assertEquals(4, life.countNeighbours(1, 1, board));

    }

    @Test
    void checkingEdgeCases() {
        board = new Board(3, 4);
        life = new Life();


        board.setValue(0, 1, 1);
        board.setValue(1, 0, 1);
        board.setValue(1, 1, 1);

        assertEquals(3, life.countNeighbours(0, 0, board));

    }

    @Test
    void calculateNextGenerationForLivingCellWithLessThanTwoNeighbours() {

        board = new Board(3, 4);
        newGenerationBoard = new Board(3, 4);
        life = new Life();
        board.setValue(0, 0, 1);
        board.setValue(0, 1, 1);
        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(0, newGenerationBoard.getValueAtPosition(0, 0));

    }

    @Test
    void calculateNextGenerationForLivingCellWithMoreThanThreeLivingNeighbours() {

        board = new Board(3, 4);
        newGenerationBoard = new Board(3, 4);
        life = new Life();
        board.setValue(1, 1, 1);
        board.setValue(0, 0, 1);
        board.setValue(0, 1, 1);
        board.setValue(1, 0, 1);
        board.setValue(1, 2, 1);
        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(0, newGenerationBoard.getValueAtPosition(1, 1));

    }

    @Test
    void calculateNextGenerationForLivingCellWithThreeLivingNeighbours() {

        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life();
        board.setValue(1, 1, 1);
        board.setValue(0, 0, 1);
        board.setValue(0, 1, 1);
        board.setValue(1, 0, 1);

        board.setValue(3, 4, 1);
        board.setValue(2, 4, 1);
        board.setValue(3, 3, 1);

        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(1, newGenerationBoard.getValueAtPosition(1, 1));

        assertEquals(1, newGenerationBoard.getValueAtPosition(3, 4));

    }

    @Test
    void calculateNextGenerationForDeadCellWithThreeLivingNeighbours() {

        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life();
        board.setValue(1, 1, 0);
        board.setValue(0, 0, 1);
        board.setValue(0, 1, 1);
        board.setValue(1, 0, 1);

        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(1, newGenerationBoard.getValueAtPosition(1, 1));

    }

    @Test
    void calculateNextGenerationForDeadCellWithNoThreeLivingNeighbours() {

        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life();
        board.setValue(1, 1, 0);
        board.setValue(0, 0, 1);
        board.setValue(0, 1, 1);


        board.setValue(3, 4, 0);
        board.setValue(2, 4, 1);
        board.setValue(3, 3, 1);
        board.setValue(3, 5, 1);
        board.setValue(4, 4, 1);

        board.setValue(0, 4, 0);

        life.calculateNextGeneration(board, newGenerationBoard);
        assertEquals(0, newGenerationBoard.getValueAtPosition(1, 1));
        assertEquals(0, newGenerationBoard.getValueAtPosition(3, 4));
        assertEquals(0, newGenerationBoard.getValueAtPosition(0, 4));


    }

    @Test
    void checkIfValuesTransferredBetweenBoards() {
        board = new Board(5, 6);
        newGenerationBoard = new Board(5, 6);
        life = new Life();
        life.initializeBoard(board);
        life.calculateNextGeneration(board, newGenerationBoard);
        life.transferNewToCurrent(board, newGenerationBoard);


        assertTrue(Arrays.deepEquals(board.getBoard(), newGenerationBoard.getBoard()));


    }

    @Test
    void checkDisplayBoard() {

        board = new Board(3, 3);
        life = new Life();

        board.setValue(0, 0, 1);
        board.setValue(0, 1, 0);
        board.setValue(0, 2, 1);
        board.setValue(1, 0, 0);
        board.setValue(1, 1, 1);
        board.setValue(1, 2, 0);
        board.setValue(2, 0, 1);
        board.setValue(2, 1, 0);
        board.setValue(2, 2, 1);
        assertEquals("*" + " " + "." + " " + "*" + " " + "\n" + "." + " " + "*" + " " + "." + " "+"\n"+"*"+" "+"."+" "+"*"+" "
                , Arrays.deepToString(life.displayBoard(board)).replace("], [", "\n").replace("[", "")
                        .replace("]", "").replace(", ", ""));
        System.out.println();
        assertEquals(Arrays.deepToString(board.getBoard()).replace("1", "*"+" ").replace("0", "."+" ")
                , Arrays.deepToString(life.displayBoard(board)));

    }



}
