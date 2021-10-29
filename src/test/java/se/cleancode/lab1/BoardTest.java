package se.cleancode.lab1;

import org.assertj.core.error.AssertionErrorMessagesAggregator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

       Board board;
      Board board1;

    @Test
    void getRowsFromCreatedBoardShouldReturnRowLength(){
            board= new Board(5, 4);
        assertEquals(5,board.getRows());
    }
    @Test
   void getColumnsFromCreatedBoardShouldReturnColumnLength(){
        board= new Board(3, 2);
        assertEquals(2,board.getColumns());

}
   @Test
   void checkIfBoardIsCreated(){
       board= new Board(6, 4);
      assertTrue(board.getRows()==6 & board.getColumns()==4);

   }

   @Test
   void checkIfAssignedValueToTheBoardWorks(){
       board= new Board(4, 3);
       board.setValue(1, 2, 5);
       assertEquals(5,board.getValueAtPosition(1,2));

   }


}
