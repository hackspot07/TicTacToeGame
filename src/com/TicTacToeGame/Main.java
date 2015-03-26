package com.TicTacToeGame;

public class Main {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        Game game = new Game(board);
        try {
            game.playGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
