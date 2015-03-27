package com.TicTacToeGame;

import java.util.HashSet;
import java.util.Set;

public class Result {
    private final Board board;
    private final int maxSize =3;

    public Result(Board board) {
        this.board = board;
    }

    public boolean hasWon(Player player) {
        Set<String> lDSet = new HashSet<String>();
        Set<String> rDSet = new HashSet<String>();
        for (int i = 0; i < maxSize; i++) {
            if(allChecksForWinning(player,lDSet, rDSet, i))
                return true;
        }
        return (checkWinning(player, lDSet, rDSet));
    }

    private boolean checkWinning(Player player, Set<String> lDSet, Set<String> rDSet) {
        return (isWining(lDSet, player) || isWining(rDSet, player));
    }

    private boolean  allChecksForWinning(Player player, Set<String> lDSet, Set<String> rDSet, int i) {
        Set<String> rowSet = new HashSet<String>();
        Set<String> colSet = new HashSet<String>();
        for (int j = 0; j < maxSize; j++) {
            rowSet.add(board.getCoordinates()[i][j]);
            colSet.add(board.getCoordinates()[j][i]);
            putIntoDiagonalSet(lDSet, i, j, rDSet);
        }
        return (checkWinning(player, rowSet, colSet));
    }

    private void putIntoDiagonalSet(Set<String> lDSet, int i, int j, Set<String> rDSet) {
        if(i==j)
            lDSet.add(board.getCoordinates()[i][j]);
        if(i+j == maxSize-1)
            rDSet.add(board.getCoordinates()[i][j]);
    }

    boolean isWining(Set<String> set, Player player) {
        if (set.size() == 1 && set.contains(player.getName()))
            return true;
        return false;
    }

    public void hasTied(int count) throws Exception {
        if(count == 9) {
            board.printBoard();
            throw new Exception("Match Tied Try Again");
        }
    }
}