package common;

import board.Cell;
import enums.ShipTypes;

public class ShipPlacementRequest {
    ShipTypes shipType;
    int width;
    int height;

    Cell startingPoint;

    public ShipTypes getShipType()   { return  shipType;  }

    public void setShipType(char shipType) {
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
