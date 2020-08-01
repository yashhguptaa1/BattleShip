package common;

import board.Cell;
import enums.ShipTypes;

public class ShipPlacementRequest {
    ShipTypes shipType;
    private final int width;
    private final int height;
    private Cell startingPoint;

    public ShipPlacementRequest(ShipTypes shipType, int height, int width, Cell startingPoint) {
        this.shipType = shipType;
        this.width = width;
        this.height = height;
        this.startingPoint = startingPoint;
    }

    public ShipTypes getShipType()
    { return  shipType;  }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getStartingPoint() {
        return startingPoint;
    }
    
}
