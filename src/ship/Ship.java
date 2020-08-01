package ship;
import board.Cell;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {

//    check why can't we use primitive types here
//    protected final ShipTypes type;
//    protected final int strength;
    protected final Cell startingPoint;
    ArrayList<Cell> shipCoords;

    protected Ship( Cell start)
    {
        this.startingPoint = start;
    }

    public void setShipCoords(ArrayList<Cell> shipCoords) {
        this.shipCoords = shipCoords;
    }

    public boolean isSunk() {
        boolean result = true;
        for(Cell cell: shipCoords) {
            if(!cell.isSunk()) {
                result = false;
                return result;
            }
        }
        return result;
    }

    public List<Cell> getOccupiedCells()
    {
        return shipCoords;
    }

}
