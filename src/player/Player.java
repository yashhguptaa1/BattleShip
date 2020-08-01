package player;


import board.BattleGround;
import board.Cell;
import common.ShipPlacementRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player implements IPlayer{

    int id;
    String playerName;
    int chanceNumber;

    private ArrayList<String>guesses;

    BattleGround ground;

    Player(BattleGround bg,HashMap<String,Integer>count,ArrayList<String>guesses)
    {
        this.chanceNumber=0;
        this.ground=bg;
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
            ground.placeShip(req);
        }
    }

    @Override
    public void getNextTarget(Cell target) {

    }

    @Override
    public String checkOutcome(Cell hit) {
        return null;
    }

    @Override
    public void checkStatus() {

    }
}
