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
            Player player = getPlayer(count);
            System.out.println("Play Mr.  "+player.getName());
            System.out.println("Enter Row And Column Number Between 0-2:");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board.isValidCoordinate(row, col))
                play(player, row, col);
            else
                System.out.println("Enter valid coordinate ");
        }

    }

    private void play(Player player ,int row, int col) throws Exception {
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
