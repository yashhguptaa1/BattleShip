package ship;

import board.Cell;
import enums.ShipTypes;

public class PShip extends Ship {

    public static final ShipTypes shipType = ShipTypes.P;
    public static final int strength = 1;

    public PShip(Cell start) {
        super(start);
    }
}

