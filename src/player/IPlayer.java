package player;

import board.Cell;
import common.ShipPlacementRequest;
import enums.Outcome;

import java.util.List;

public interface IPlayer {
    void placeShips(List<ShipPlacementRequest> requestList);

    void getNextTarget(Cell target);

    Outcome checkOutcome(Cell hit);

    void checkStatus();

    String getName();

    boolean checkAllShipsSunk();
}
