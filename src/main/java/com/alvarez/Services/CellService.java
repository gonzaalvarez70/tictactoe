package com.alvarez.Services;

import com.alvarez.Enums.CellStatus;
import java.util.Arrays;

public class CellService {

    public static CellStatus[][] initializeCells(int boardSizeX, int boardSizeY)
    {
        CellStatus[] row = new CellStatus[boardSizeY];
        CellStatus[][] board = new CellStatus[boardSizeX][boardSizeY];
        Arrays.fill(row, CellStatus.UNSELECTED);
        Arrays.fill(board, row);
        return board;
    }
}
