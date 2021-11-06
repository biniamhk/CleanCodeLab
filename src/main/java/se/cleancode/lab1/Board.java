package se.cleancode.lab1;

public class Board {
    private int[][] board;
    private int rows;
    private int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new int[rows][cols];
    }

    public int[][] getBoard() {
        return board;
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


    public String toString() {
        StringBuilder boardResult = new StringBuilder();
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getColumns(); col++) {
                boardResult.append(board[row][col]);
            }
            boardResult.append("\n");
        }
        return boardResult.toString();
    }

    public void setAlive(int row, int col) {
        board[row][col] = 1;
    }

    public void setDead(int row, int col) {
        board[row][col] = 0;
    }
}
