package com.TicTacToeGame;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        try {
            game.playGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
