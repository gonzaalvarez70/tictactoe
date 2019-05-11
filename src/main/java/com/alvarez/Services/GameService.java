package com.alvarez.Services;

import com.alvarez.Entities.Game;
import com.alvarez.Enums.CellStatus;

public class GameService {

    private static final int BOARD_SIZE_X = 3;
    private static final int BOARD_SIZE_Y = 3;

    public static Game newGame(){
        CellStatus[][] board = CellService.initializeCells(BOARD_SIZE_X, BOARD_SIZE_Y);
        return new Game(board);
    }
}
