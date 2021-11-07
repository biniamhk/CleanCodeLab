package se.cleancode.lab1;

import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("welcome to Game of Life");
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;

        Life life = new Life(new MathRandomImplementation());

        System.out.println("Enter number rows");
        row = scanner.nextInt();
        System.out.println("Enter number cols");
        col = scanner.nextInt();


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



