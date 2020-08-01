package player;

import board.Cell;
import common.ShipPlacementRequest;

import java.util.List;

public interface IPlayer {
    void placeShips(List<ShipPlacementRequest> requestList);

    void getNextTarget(Cell target);

    String checkOutcome(Cell hit);

    void checkStatus();
}
