package com.TicTacToeGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Result {
    private final Board board;

    public Result(Board board) {
        this.board = board;
    }

    public boolean hasWon(Player player) {
        for (int i = 0; i < 3; i++) {
            Set<String> rowSet = new HashSet<String>();
            Set<String> colSet = new HashSet<String>();
            for (int j = 0; j < 3; j++) {
                rowSet.add(board.getCoordinates()[i][j]);
                colSet.add(board.getCoordinates()[j][i]);
            }
            if (isWining(colSet, player) || isWining(rowSet, player))
                return true;

        }
        return false;
    }

    boolean isWining(Set<String> set, Player player) {
        if (set.size() == 1 && set.contains(player.getName()))
            return true;
        return false;
    }

    public void hasTied(int count) throws Exception {
        if(count==9) {
            board.printBoard();
            throw new Exception("Match Tied Try Again");
        }
    }
}