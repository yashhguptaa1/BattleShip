import board.Cell;
import common.ShipPlacementRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InitialzingGame {

    public static void main(String[] args)  throws IOException {

        File file = new File("C:\\Users\\yashh\\Desktop\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String firstLine = br.readLine().trim();
        String[] first = firstLine.split("\\s");
        int nRows=(int)(first[1].charAt(0)-'A')+1;
        int nCols=Integer.parseInt(first[0]);

        //System.out.println(nRows +" "+nCols );

        int numofships=Integer.parseInt(br.readLine().trim());

        List<ShipPlacementRequest>PlacmentsP1=new ArrayList<>();
        List<ShipPlacementRequest>PlacmentsP2=new ArrayList<>();


        while(numofships-- >0) {
            String ipLine = br.readLine().trim();
            String[] ips = ipLine.split("\\s+");

            char type = ips[0].charAt(0);
            int dim1 = Integer.parseInt(ips[1]);
            int dim2 = Integer.parseInt(ips[2]);

            //FOR PLAYER 1
            int AstartX=(int)(ips[3].charAt(0)-'0');
            int AstartY=(int)ips[3].charAt(1);

            ShipPlacementRequest plyr1 = new ShipPlacementRequest();
            plyr1.setHeight(dim1);
            plyr1.setWidth(dim2);
            plyr1.setShipType(type);
            Cell startCell=new Cell();
            startCell.setRow((int)(ips[3].charAt(0)-'0'));
            startCell.setCol((int)ips[3].charAt(1));
            plyr1.setStartingPoint(startCell);
            PlacmentsP1.add(plyr1);


            //FOR PLAYER 2
            ShipPlacementRequest plyr2 = new ShipPlacementRequest();
            plyr2.setHeight(dim1);
            plyr2.setWidth(dim2);
            plyr2.setShipType(type);
            Cell begCell=new Cell();
            begCell.setRow((int)(ips[4].charAt(0)-'0'));
            begCell.setCol((int)ips[4].charAt(1));
            plyr1.setStartingPoint(begCell);
            PlacmentsP2.add(plyr2);
        }

        //FOR PLAYER 1
        String P1= br.readLine().trim();
        String[] p1 = P1.split("\\s");
        ArrayList<String>allGuessesP1=new ArrayList<>();
        for(String s:p1)
        {
            allGuessesP1.add(s);
        }

        //FOR PLAYER 2
        String P2= br.readLine().trim();
        String[] p2 = P2.split("\\s");
        ArrayList<String>allGuessesP2=new ArrayList<>();
        for(String s:p2)
        {
            allGuessesP2.add(s);
        }

       // System.out.println(allGuessesP1);
        //System.out.println(allGuessesP2);

        Game newGame=new Game();
        newGame.gameInit(nRows,nCols,PlacmentsP1,PlacmentsP2,allGuessesP1,allGuessesP2);

    }
}
