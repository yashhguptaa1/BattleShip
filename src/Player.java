import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {

    int chanceNumber;

    private HashMap<String,Integer>countShips;
    private ArrayList<String>guesses;

    BattleGround ground;

    Player(BattleGround bg,HashMap<String,Integer>count,ArrayList<String>guesses)
    {
        this.chanceNumber=0;
        this.ground=bg;
        this.countShips=new HashMap<>(count);
        this.guesses=new ArrayList<>(guesses);

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

}
