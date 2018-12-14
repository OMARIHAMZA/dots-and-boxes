package omari.hamza;

import omari.hamza.core.Board;
import omari.hamza.core.GameController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(4);
        String p1 = "H", p2 = "M";
        String currentPlayer = "H";
        boolean hasNextMove = false;
        System.out.println(board.toString());
        while (!board.isGameOver()) {
            System.out.print("Enter your move " + currentPlayer + ": ");
            hasNextMove = board.applyMove(new Scanner(System.in).nextInt(), currentPlayer);
            System.out.println(board.toString());
            if (!hasNextMove) {
                currentPlayer = (currentPlayer.equals(p1)) ? p2 : p1;
            }
        }
        int playerOneScore = board.numOfBoxesOwned(p1);
        int playerTwoScore = board.numOfBoxesOwned(p2);
        if (playerOneScore > playerTwoScore) {
            System.out.println(p1 + " Wins!");
        } else if (playerOneScore == playerTwoScore) {
            System.out.println("Tie!");
        } else {
            System.out.println(p2 + " Wins!");
        }
    }
}
