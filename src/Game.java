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

    public void gameInit(int nRows, int nCols, List<ShipPlacementRequest> PlacmentsP1,List<ShipPlacementRequest>PlacmentsP2,ArrayList<String>allGuessesP1,ArrayList<String>allGuessesP2)
    {
        BattleGround bg1=new BattleGround(nRows,nCols);
        BattleGround bg2=new BattleGround(nRows,nCols);

        A=new Player(bg1, "Player-1");
        B=new Player(bg2, "Player-2");

        A.placeShips(PlacmentsP1);
        B.placeShips(PlacmentsP2);

        A.setGuessList(allGuessesP1);
        B.setGuessList(allGuessesP2);

    }

    public void startGame()
    {
        Player currPlayer = A;
        Player opponent = B;

        while (true) {
            Cell target = currPlayer.getNextTarget();
            //cannot return NO_MISSILE
            if(target == null) {
                System.out.println(currPlayer.getName() + " has no missiles left");
                swapTurn(currPlayer, opponent);
                continue;
            }
            //TODO remove this enum
            Outcome outcome = opponent.checkOutcome(target);

            if(outcome == Outcome.HIT) {
                System.out.println(currPlayer.getName() + " fires a missile with target " + target.getName() + " which got hit.");
                if (checkIfOpponentLost(opponent)) {
                    winner = currPlayer;
                    break;
                }
            } else {
                System.out.println(currPlayer.getName() + " fires a missile with target " + target.getName() + " which got hit.");
                swapTurn(currPlayer, opponent);
            }
        }
    }

    private boolean checkIfOpponentLost(Player opponent) {
        return opponent.checkAllShipsSunk();
    }

    private void swapTurn(Player currPlayer, Player opponent) {
        Player temp = currPlayer;
        currPlayer = opponent;
        opponent = currPlayer;
    }

}
