package se.cleancode.lab1;

public class Board {
    private int[][] board;
    private int rows;
    private int cols;
    public Board(int rows, int cols) {
        this.rows=rows;
        this.cols=cols;
        this.board=new int[rows][cols];
    }


    public int getRows() {
        return board.length;
    }

    public int getColumns() {
        return board[0].length;
    }

    public void setValue(int row, int col, int value) throws ArrayIndexOutOfBoundsException {
        try {
            board[row][col] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("enter a valid index");

        }
    }
    public int getValueAtPosition(int row, int col) {
        return board[row][col];
    }

    public String toString(){
        String boardResult="";
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns() ; col++) {
                boardResult+=board[row][col];
            }
            boardResult+= "\n";
        }
        return boardResult;
    }
}
