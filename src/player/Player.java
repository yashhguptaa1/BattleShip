package player;


import board.BattleGround;
import board.Cell;
import common.ShipPlacementRequest;
import enums.Outcome;
import enums.ShipTypes;
import ship.PShip;
import ship.QShip;
import ship.Ship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static enums.Outcome.MISS;

public class Player implements IPlayer{

    private String playerName;
    private int chanceNumber;

    private ArrayList<String> guesses;
    private ArrayList<Ship> fleet;
    private Set<String> occupiedCells;
    BattleGround ground;

    public Player(BattleGround bg, String name)
    {
        this.playerName     = name;
        this.chanceNumber   = 0;
        this.ground         = bg;
        this.fleet          = new ArrayList<>();
        this.occupiedCells  = new HashSet<>();
    }

    public int[] getNext()
    {
        String guess=guesses.get(this.chanceNumber);
        this.chanceNumber++;
        int guessIndex[]=new int[2];
        guessIndex[0]=(int)(guess.charAt(0)-'A');
        guessIndex[1]=(int)(guess.charAt(1)-'1');
        return guessIndex;
    }

    @Override
    public void placeShips(List<ShipPlacementRequest> requestList) {
        for(ShipPlacementRequest req: requestList) {
            //TODO when there no default constructor how it is allowed
            Ship ship;
            switch (req.getShipType()) {
                case P:
                    ship = new PShip(req.getStartingPoint());
                case Q:
                    ship = new QShip(req.getStartingPoint());
                default:
                    ship = null;
            }
            if(ship != null)
                fleet.add(ship);
            List<Cell> shipPlacementCells = ground.placeShip(req);
            ship.setShipCoords(shipPlacementCells);

            //TODO implement Algo using this
            for(Cell cell: shipPlacementCells) {
                occupiedCells.add(cell.getName());
            }
        }
    }

    @Override
    public void getNextTarget(Cell target) {

    }

    @Override
    public Outcome checkOutcome(Cell hit) {
        if(occupiedCells.contains(hit.getName()) && hit.isHit()) {
            return Outcome.HIT;
            //return true;
        }
        return MISS;
    }

    @Override
    public void checkStatus() {

    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public boolean checkAllShipsSunk() {

        for(Ship ship: fleet) {
            if(! ship.isSunk())
                return false;
        }
        return true;
    }

    public void setGuessList(ArrayList<String>guesses)
    {
        this.guesses=new ArrayList<>(guesses);
    }
}
