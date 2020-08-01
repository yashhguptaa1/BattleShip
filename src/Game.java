import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    Player A;
    Player B;
    int numOfMissiles;

    Game(int n, BattleGround bg1, BattleGround bg2, HashMap<String,Integer> h1,HashMap<String,Integer> h2,ArrayList<String>allGuessesP1,ArrayList<String>allGuessesP2)
    {
        A=new Player(bg1,h1,allGuessesP1);
        B=new Player(bg2,h2,allGuessesP2);
        this.numOfMissiles=n;

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


}
