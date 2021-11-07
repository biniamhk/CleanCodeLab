package se.cleancode.lab1;

import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("welcome to Game of Life");
        Scanner scanner = new Scanner(System.in);
        int row = 4;
        int col = 8;

        Life life = new Life(new MathRandomImplementation());


        Board board = new Board(row, col);
        Board newBoard = new Board(row, col);
        life.initializeBoard(board);

        for (int i = 0; i < 5; i++) {
            System.out.flush();
            System.out.println("Generation" + ":" + (i + 1));
            life.displayBoard(board);
            Thread.sleep(1000);
            life.calculateNextGeneration(board, newBoard);
            life.transferNewToCurrent(board, newBoard);
            System.out.println();
            System.out.println();

        }

    }
}



