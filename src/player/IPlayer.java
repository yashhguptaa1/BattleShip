package player;

import board.Cell;
import common.ShipPlacementRequest;
import enums.Outcome;

import java.util.ArrayList;
import java.util.List;

public interface IPlayer {
    void placeShips(List<ShipPlacementRequest> requestList);

    Cell getNextTarget();

    Outcome checkOutcome(Cell hit);

    void checkStatus();

    String getName();

    boolean checkAllShipsSunk();

    void setGuessList(ArrayList<Cell> guesses);

}
