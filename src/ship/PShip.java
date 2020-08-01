package ship;

import board.Cell;

public class PShip extends Ship {

    public static final ShipTypes shipType = ShipTypes.P;
    public static final int strength = 1;

    public PShip(Cell start) {
        super(start);
    }
}

