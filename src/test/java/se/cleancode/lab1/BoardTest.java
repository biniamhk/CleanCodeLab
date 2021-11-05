package se.cleancode.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board board;

    @Test
    void getRowsFromCreatedBoardShouldReturnRowLength() {
        board = new Board(5, 4);
        assertEquals(5, board.getRows());
    }

    @Test
    void getColumnsFromCreatedBoardShouldReturnColumnLength() {
        board = new Board(3, 2);
        assertEquals(2, board.getColumns());

    }

    @Test
    void checkIfBoardIsCreated() {
        board = new Board(6, 4);
        assertTrue(board.getRows() == 6 & board.getColumns() == 4);

    }

    @Test
    void checkIfSetAliveWorks() {
        board = new Board(4, 3);
        board.setAlive(1, 2);
        assertEquals(1, board.getValueAtPosition(1, 2));

    }

    @Test
    void checkIfSetDeadWorks() {
        board = new Board(4, 3);
        board.setDead(1, 2);
        assertEquals(0, board.getValueAtPosition(1, 2));

    }

    @Test
    void testToStringMethod() {
        board = new Board(2, 2);


    }


}
