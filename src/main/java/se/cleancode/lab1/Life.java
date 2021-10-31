package se.cleancode.lab1;

public class Life {
    public int initializeBoard(Board board) {
        int numberOfLivingCells = 0;
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                int random = (int)(Math.random()*3);
                if(random==0){
                    board.setValue(row, col,1);
                    numberOfLivingCells++;
                }
            }
        }
        return numberOfLivingCells;
    }
}
