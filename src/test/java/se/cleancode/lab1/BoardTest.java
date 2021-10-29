package se.cleancode.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Board board=new Board(5,4);

    @Test
    void getRowsFromCreatedBoardShouldReturnRowLength(){

        assertEquals(5,board.getRows());

    }


}
