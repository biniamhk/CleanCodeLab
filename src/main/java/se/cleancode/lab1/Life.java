package se.cleancode.lab1;

public class Life {
    public int initializeBoard(Board board) {
        int numberOfLivingCells = 0;

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                int random = (int) (Math.random() * 3);
                if (random == 0) {
                    board.setValue(row, col, 1);
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
                if (c >= 0 && c < board.getColumns() &&
                        r >= 0 && r < board.getRows() &&
                        !(r == row && c == col) &&
                        board.getValueAtPosition(r, c) == 1) {
                    count = count + 1;
                }
            }
        }

        return count;
    }

    public void calculateNextGeneration(Board board, Board newGenerationBoard) {
        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                int numberOfLivingNeighbours = countNeighbours(row, col, board);
                if (board.getValueAtPosition(row, col) == 1 && numberOfLivingNeighbours < 2) {
                    newGenerationBoard.setValue(row, col, 0);
                }
                else if(board.getValueAtPosition(row,col)==1 && numberOfLivingNeighbours >3){
                    newGenerationBoard.setValue(row, col, 0);
                }
                else if (board.getValueAtPosition(row, col) == 1 && numberOfLivingNeighbours <= 3 ) {
                    newGenerationBoard.setValue(row, col, 1);
                }
                else if (board.getValueAtPosition(row, col) == 0 && numberOfLivingNeighbours == 3 ) {
                    newGenerationBoard.setValue(row, col, 1);
                }
                else {
                    newGenerationBoard.setValue(row, col, 0);
                }

                }

            }
        }
    }
