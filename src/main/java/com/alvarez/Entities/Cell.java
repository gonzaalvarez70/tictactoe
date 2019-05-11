package com.alvarez.Entities;

import com.alvarez.Enums.CellStatus;

public class Cell {

    private int x, y;
    private CellStatus cellStatus;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.cellStatus = CellStatus.UNSELECTED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }
}
