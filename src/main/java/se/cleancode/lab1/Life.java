package se.cleancode.lab1;

public class Life {

    private MathRandom mathRandom;

    public Life(MathRandom mathRandom) {
        this.mathRandom = mathRandom;
    }
    public Life() {
    }

    public int initializeBoard(Board board) {
        int numberOfLivingCells = 0;
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                int randomNumber = mathRandom.mathRandom(3);
                if (randomNumber == 0) {
                    board.setAlive(row, col);
                    numberOfLivingCells++;
                }
            }
        }
        return numberOfLivingCells;
    }

    public int countNeighbours(int row, int col, Board board) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (checkEdgeCases(board, r, c)) {
                    if (board.getValueAtPosition(r, c) == 1 && !(r == row && c == col)) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }

    public boolean checkNeighbourOfLivingCell(int row, int col, Board board) {
        int numberOfLivingNeighbours = countNeighbours(row, col, board);
        if (board.getValueAtPosition(row, col) == 1) {
            return numberOfLivingNeighbours >= 2 && numberOfLivingNeighbours <= 3;
        }
        return false;
    }

    public boolean checkNeighbourOfDeadCell(int row, int col, Board board) {
        int numberOfLivingNeighbours = countNeighbours(row, col, board);
        return board.getValueAtPosition(row, col) == 0 && numberOfLivingNeighbours == 3;
    }

    public boolean checkEdgeCases(Board board, int r, int c) {
        return c >= 0 && c < board.getColumns() && r >= 0 && r < board.getRows();
    }

    public void calculateNextGeneration(Board board, Board newGenerationBoard) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                if (checkNeighbourOfLivingCell(row, col, board) || (checkNeighbourOfDeadCell(row, col, board))) {
                    newGenerationBoard.setAlive(row, col);
                } else {
                    newGenerationBoard.setDead(row, col);
                }
            }
        }
    }

    public void transferNewToCurrent(Board board, Board newBoard) {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getColumns(); c++) {
                board.setValue(r, c, newBoard.getValueAtPosition(r, c));
            }
        }
    }

    public String[][] displayBoard(Board board) {
        String[][] console = new String[board.getRows()][board.getColumns()];

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                if (board.getValueAtPosition(row, col) == 0) {
                    System.out.print("." + " ");
                    console[row][col] = "." + " ";
                } else {
                    System.out.print("*" + " ");
                    console[row][col] = "*" + " ";
                }

            }
            System.out.println();
        }
        return console;
    }
}
