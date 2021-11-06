package se.cleancode.lab1;

public class GameOfLife {

    public static void main(String[] args) throws InterruptedException {

        Life life= new Life(new MathRandomImplementation());


        final int rows=6;
        final int cols=8;
        Board board=new Board(rows,cols);
        Board newBoard=new Board(rows,cols);

        life.initializeBoard(board);

        for (int i = 0; i < 5; i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Generation"+":"+(i+1));

            life.displayBoard(board);

            Thread.sleep(500);
            life.calculateNextGeneration(board,newBoard);
            life.transferNewToCurrent(board,newBoard);
            System.out.println();
            System.out.println();

        }

    }


}
