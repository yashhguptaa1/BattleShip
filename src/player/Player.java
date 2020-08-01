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

    public Player(BattleGround bg)
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

    public void addShips(String startingPoint,int dim1,int dim2,char type)
    {
        int totalLifeOfShip=0;
        if(type=='P')
        {
            totalLifeOfShip=dim1*dim2;
        }
        else
            totalLifeOfShip=dim1*dim2*2;

        countShips.put(startingPoint,totalLifeOfShip);
    }
    public void onHit(String startPoint)
    {
        int currLifeRemaining=countShips.get(startPoint);

        if(currLifeRemaining==1)
        {
            countShips.remove(startPoint);
        }
        else
        {
            countShips.put(startPoint,currLifeRemaining-1);
        }
    }

    public int numberOfShips()
    {
        return countShips.size();
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

    public void setGuessList(ArrayList<String>guesses)
    {
        this.guesses=new ArrayList<>(guesses);
    }
}
