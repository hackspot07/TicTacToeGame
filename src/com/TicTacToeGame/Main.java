package com.TicTacToeGame;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        try {
            game.runGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
