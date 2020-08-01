package common;

import board.Cell;

public class ShipPlacementRequest {
    int shipType;
    int width;
    int height;

    Cell startingPoint;

    public int getShipType() {
        return shipType;
    }

    public void setShipType(int shipType) {
        this.shipType = shipType;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Cell startingPoint) {
        this.startingPoint = startingPoint;
    }
}
