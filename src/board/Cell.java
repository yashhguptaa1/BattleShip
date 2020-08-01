package board;

public class Cell {

    char type;
    int value;
    String startingPoint;
    boolean occupied;


    public Cell(char type, int value, String startingPoint, boolean occupied) {
        this.type = type;
        this.value = value;
        this.startingPoint = startingPoint;
        this.occupied = occupied;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void occupy(int strength) {
        this.occupied = true;
        this.value = strength;

        System.out.println("cell is being occupied");
    }
}
