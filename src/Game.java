import board.BattleGround;
import board.Cell;
import common.ShipPlacementRequest;
import player.Player;
import ship.Ship;

import java.util.*;

public class Game {

    Player A;
    Player B;

    Game()
    {

    }

    public void start()
    {
       startGame(A,B);
    }

    public void startGame(Player A,Player B)
    {

        int guessOfA[]=A.getNext();

        int guessOfB[]=B.getNext();

        for(int n:guessOfA)
            System.out.println(n);

        for(int n:guessOfB)
            System.out.println(n);

        if(A.numberOfShips()>B.numberOfShips())
        {
            System.out.println("Player-1 won the battle");

        }
        else {
            System.out.println("Player-2 won the battle");

        }


    }

    public void gameInit(int nRows, int nCols, List<ShipPlacementRequest> PlacmentsP1,List<ShipPlacementRequest>PlacmentsP2,ArrayList<String>allGuessesP1,ArrayList<String>allGuessesP2)
    {
        BattleGround bg1=new BattleGround(nRows,nCols);
        BattleGround bg2=new BattleGround(nRows,nCols);

        A=new Player(bg1);
        B=new Player(bg2);

        A.placeShips(PlacmentsP1);
        B.placeShips(PlacmentsP2);

        A.setGuessList(allGuessesP1);
        B.setGuessList(allGuessesP2);

    }

}
