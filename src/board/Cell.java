package board;

import ship.Ship;

public class Cell {

    int value;
    boolean occupied;
    Ship ship;
    int row;
    int col;

    public Cell ()
    {
        this.value = 0;
        this.occupied = false;

    }

    public Cell(int value, boolean occupied, Ship ship) {
        this.value = value;
        this.occupied = occupied;
        this.ship = ship;
    }

    public void addCoordToShip(int rowNum, int colNum) {
        ship.addCoordToList(rowNum, colNum);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void occupy(int strength) {
        this.occupied = true;
        this.value = strength;

        System.out.println("cell is being occupied");
    }

}

