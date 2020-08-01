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
    private ArrayList<Cell>guesses;
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

    @Override
    public Cell getNextTarget() {

        if(this.chanceNumber>=guesses.size())
            return null;

        Cell currGuess=guesses.get(this.chanceNumber);
        this.chanceNumber++;
        return currGuess;
    }

    @Override
    public void placeShips(List<ShipPlacementRequest> requestList) {

        for(ShipPlacementRequest req: requestList) {
            //TODO when there no default constructor how it is allowed
            Ship ship;
            switch (req.getShipType()) {
                case P:
                    ship = new PShip(req.getStartingPoint());
                    break;
                case Q:
                    ship = new QShip(req.getStartingPoint());
                    break;
                default:
                    ship = null;
            }
            if(ship != null)
                fleet.add(ship);
            List<Cell> shipPlacementCells = ground.placeShip(req);
            //System.out.println("zRequestlist "+shipPlacementCells);
            ship.setShipCoords(shipPlacementCells);

            //TODO implement Algo using this
            for(Cell cell: shipPlacementCells) {
                occupiedCells.add(cell.getName());
            }
            //System.out.println("occupiedCells "+occupiedCells);
        }
    }


    @Override
    public Outcome checkOutcome(Cell hit) {
        //System.out.println("From Outcome "+hit.getName()+" "+hit.isHit());
        Cell currCell=ground.getCurrCell(hit.getRow(),hit.getCol());
        if(occupiedCells.contains(currCell.getName()) && currCell.isHit()) {
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

    @Override
    public void setGuessList(ArrayList<Cell>guesses)
    {
        this.guesses=new ArrayList<>(guesses);
    }
}
