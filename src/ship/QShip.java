package ship;

import board.Cell;

public class QShip extends Ship {

    public static final ShipTypes shipType = ShipTypes.Q;
    public static final int strength = 2;

    public QShip(Cell start) {
        super(start);
    }
}
