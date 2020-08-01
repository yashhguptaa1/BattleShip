package board;

import ship.Ship;

public class Cell {

    private String name;
    private int value;
    private boolean occupied;
    Ship ship;
    private final int row;
    private final int col;

    public Cell (int x,int y,String name)
    {
        this.row=x;
        this.col=y;
        this.name=name;
        this.value = 0;
        this.occupied = false;

    }

    public Cell(int x,int y)
    {
        this.row=x;
        this.col=y;
    }

    public int getValue() {
        return value;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getName() {
        return name;
    }

    public void occupy(int strength) {
        this.occupied = true;
        this.value = strength;

        //System.out.println("cell is being occupied");
    }

    public boolean isSunk() {
        return this.value == 0;
    }

    public boolean isHit() {
        //System.out.println("From Hit "+occupied+" "+value);
        if(occupied && value>0){
            value --;
            return true;
        }
        return false;
    }
}

