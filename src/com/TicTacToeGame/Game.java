package com.TicTacToeGame;

import java.util.Scanner;

public class Game {
    private Board board;
    private final Player x;
    private final Player o;
    private int count = 1;

    public Game(Board board) {
        this.board = board;
        x = new Player("x");
        o = new Player("o");
    }

    public void playGame() throws Exception {
        while (true) {
            board.printBoard();
            System.out.println("Enter Row And Column Number Between 0-2:");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board.isValidCoordinate(row, col))
                play(row, col);
            else
                System.out.println("Enter valid coordinate");
        }

    }

    private void play(int row, int col) throws Exception {
        Player player = getPlayer(count);
        board.setValue(player,row, col);
        if(board.hasWon(player)) {
            board.printBoard();
            throw new Exception("Congratulation You Won " + player.getName());
        }
        board.result.hasTied(count);
        count++;
    }

    private Player getPlayer(int count) {
        return (count%2==0) ? o : x;
    }
}
