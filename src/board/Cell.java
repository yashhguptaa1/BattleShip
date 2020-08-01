package board;

import ship.Ship;

public class Cell {

    int value;
    boolean occupied;
    Ship ship;

    public Cell(int value, boolean occupied, Ship ship) {
        this.value = value;
        this.occupied = occupied;
        this.ship = ship;
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



    public void occupy(int strength) {
        this.occupied = true;
        this.value = strength;

        System.out.println("cell is being occupied");
    }

    public boolean isSunk() {
        return this.value == 0;
    }
}

