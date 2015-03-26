package com.TicTacToeGame;

public class Board {
    final Result result = new Result(this);
    private String[][] coordinates = new String[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.coordinates[i][j] = "__";
            }
        }
    }

    public void printBoard() {
        for (String[] coordinate : coordinates) {
            for (String s : coordinate) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setValue(Player player, int row, int col) {
        this.coordinates[row][col] = player.getName() ;
    }

    boolean isValidCoordinate(int row, int col) {
        if(row < 3 && row >=0 && col>=0 && col<3){
            if(this.coordinates[row][col].equals("__"))
                return  true;
        }
        return false;
    }

    public boolean hasWon(Player player) {
        return result.hasWon(player);
    }

    public String[][] getCoordinates() {
        return coordinates;
    }
}
