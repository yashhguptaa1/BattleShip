import board.BattleGround;
import board.Cell;
import common.ShipPlacementRequest;
import enums.Outcome;
import player.Player;
import ship.Ship;

import java.util.*;

public class Game {

    Player A;
    Player B;
    Player winner;

    Game()
    {

    }


    public void gameInit(int nRows, int nCols, List<ShipPlacementRequest> PlacmentsP1,List<ShipPlacementRequest>PlacmentsP2,ArrayList<Cell>allGuessesP1,ArrayList<Cell>allGuessesP2)
    {
        BattleGround bg1=new BattleGround(nRows,nCols);
        BattleGround bg2=new BattleGround(nRows,nCols);

        A=new Player(bg1, "Player-1");
        B=new Player(bg2, "Player-2");

        A.placeShips(PlacmentsP1);
        B.placeShips(PlacmentsP2);

        A.setGuessList(allGuessesP1);
        B.setGuessList(allGuessesP2);

        startGame();

    }

    public void startGame()
    {
        Player currPlayer = A;
        Player opponent = B;
        PlayerWrapper pw1 = new PlayerWrapper(currPlayer);
        PlayerWrapper pw2 = new PlayerWrapper(opponent);



        while (true) {
            Cell target = pw1.p.getNextTarget();
            //cannot return NO_MISSILE
            //Cell targetOfOpponent;

            if(target == null) {

                /*target=pw2.p.getNextTarget();
                if (target==null)
                {
                    System.out.println("Battle is a Draw");
                    break;
                }*/

                System.out.println(pw1.p.getName() + " has no more missiles left to launch");
                swapTurn(pw1,pw2);
                continue;
            }
            //TODO remove this enum
            Outcome outcome = pw2.p.checkOutcome(target);

            if(outcome == Outcome.HIT) {
                System.out.println(pw1.p.getName() + " fires a missile with target " + target.getName() + " which got hit.");
                if (checkIfOpponentLost(pw2)) {
                    winner = pw1.p;
                    System.out.println(winner.getName()+" won the battle ");
                    break;
                }
            } else {
                System.out.println(pw1.p.getName() + " fires a missile with target " + target.getName() + " which got miss.");
                swapTurn(pw1, pw2);
            }
        }
    }

    private boolean checkIfOpponentLost(PlayerWrapper pw2) {
        return pw2.p.checkAllShipsSunk();
    }

    /*private void swapTurn(Player currPlayer, Player opponent) {
        Player temp = currPlayer;
        currPlayer = opponent;
        opponent = currPlayer;
    }*/

    private void swapTurn(PlayerWrapper currPlayer,PlayerWrapper opponent)
    {
        Player temp = currPlayer.p;
        currPlayer.p = opponent.p;
        opponent.p = temp;
    }

}

// A Wrapper over class that is used for swapping
class PlayerWrapper
{
    Player p;

    // Constructor
    PlayerWrapper(Player p)   {this.p = p;}
}