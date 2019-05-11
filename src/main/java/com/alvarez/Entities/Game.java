package com.alvarez.Entities;

import com.alvarez.Enums.GameStatus;

import java.util.List;

public class Game {

    private List<Cell> board;
    private long timeSpent;
    private GameStatus gameStatus;

    public Game(List<Cell> board) {
        this.timeSpent = 0;
        gameStatus = GameStatus.IN_PROGRESS;
        this.board = board;
    }

    public List<Cell> getBoard() {
        return board;
    }

    public void setBoard(List<Cell> board) {
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
