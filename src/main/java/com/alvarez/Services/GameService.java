package com.alvarez.Services;

import com.alvarez.Entities.Game;
import com.alvarez.Enums.CellStatus;
import com.alvarez.Enums.GameStatus;

import java.util.Random;

public class GameService {

    private static final int BOARD_SIZE_X = 3;
    private static final int BOARD_SIZE_Y = 3;

    public static Game newGame(){
        CellStatus[][] board = CellService.initializeCells(BOARD_SIZE_X, BOARD_SIZE_Y);
        return new Game(board);
    }

    public static Game playerInput(int x, int y, Game game) {
        GameStatus status = selectCell(x, y, game, CellStatus.PLAYER);
        if (status == GameStatus.IN_PROGRESS){
            status = computerInput(game);
        }

        game.setGameStatus(status);
        return game;
    }

    private static GameStatus computerInput(Game game) {
        CellStatus[][] board = game.getBoard();
        GameStatus status;
        int x, y;
        do {
            Random random = new Random();
            x = random.nextInt(game.getBoard().length);
            y = random.nextInt(game.getBoard().length);
            status = selectCell(x, y, game, CellStatus.COMPUTER);
        } while (board[x][y] != CellStatus.COMPUTER);

        return status;
    }

    private static GameStatus selectCell(int x, int y, Game game, CellStatus selection) {
        GameStatus status = GameStatus.IN_PROGRESS;
        CellStatus[][] board = game.getBoard();
        if(board[x][y] == CellStatus.UNSELECTED) {
            board[x][y] = selection;
            game.setSelectCount(game.getSelectCount() + 1);
        }
        else {
            return status;
        }

        // column check
        status = checkColumn(board, selection, x);

        // row check
        if (status  == GameStatus.IN_PROGRESS) {
            status = checkRow(board, selection, y);
        }

        // diagonal check
        if (status  == GameStatus.IN_PROGRESS) {
            status = checkDiagonal(board, selection, x, y);
        }

        // anti-diagonal check
        if (status  == GameStatus.IN_PROGRESS) {
            status = checkAntiDiagonal(board, selection, x, y);
        }

        // draw check
        if (game.getSelectCount() == board.length - 1 && status == GameStatus.IN_PROGRESS) {
            status = GameStatus.DRAW;
        }

        return status;
    }

    private static GameStatus checkColumn(CellStatus[][] board, CellStatus selection, int rowSelected) {

        for (int column = 0; column < board.length; column++) {
            if (board[rowSelected][column] != selection){
                break;
            }
            if (column == board.length - 1){
                return calculateGameResult(selection);
            }
        }

        return GameStatus.IN_PROGRESS;
    }

    private static GameStatus checkRow(CellStatus[][] board, CellStatus selection, int columnSelected){

        for (int row = 0; row < board.length; row++) {
            if (board[row][columnSelected] != selection){
                break;
            }
            if (row == board.length - 1){
                return calculateGameResult(selection);
            }
        }

        return GameStatus.IN_PROGRESS;
    }

    private static GameStatus checkDiagonal(CellStatus[][] board, CellStatus selection, int rowSelected, int columnSelected){

        if (rowSelected == columnSelected)
        {
            for(int index = 0; index < board.length; index++){
                if (board[index][index] != selection)
                    break;
                if (index == board.length - 1){
                    return calculateGameResult(selection);
                }
            }
        }

        return GameStatus.IN_PROGRESS;
    }

    private static GameStatus checkAntiDiagonal(CellStatus[][] board, CellStatus selection, int rowSelected, int columnSelected){

        if(rowSelected + columnSelected == board.length - 1){

            for (int index = 0; index < board.length; index++){
                if (board[index][(board.length - 1) - index] != selection) {
                    break;
                }
                if (index == board.length - 1) {
                    return calculateGameResult(selection);
                }
            }
        }

        return GameStatus.IN_PROGRESS;
    }

    private static GameStatus calculateGameResult(CellStatus selection){
        boolean playerWon = false;
        if (selection == CellStatus.PLAYER)
        {
            playerWon = true;
        }
        return playerWon ? GameStatus.VICTORY : GameStatus.DEFEAT;
    }
}
