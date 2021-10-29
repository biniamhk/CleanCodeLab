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
}
