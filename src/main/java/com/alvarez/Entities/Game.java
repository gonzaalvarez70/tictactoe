package com.alvarez.Entities;

import com.alvarez.Enums.CellStatus;
import com.alvarez.Enums.GameStatus;

public class Game {

    private CellStatus[][] board;
    private long timeSpent;
    private GameStatus gameStatus;

    public Game(CellStatus[][] board) {
        this.timeSpent = 0;
        gameStatus = GameStatus.IN_PROGRESS;
        this.board = board;
    }

    public CellStatus[][] getBoard() {
        return board;
    }

    public void setBoard(CellStatus[][] board) {
        this.board = board;
    }

    public long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(long timeSpent) {
        this.timeSpent = timeSpent;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
