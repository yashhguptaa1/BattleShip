import board.Cell;
import common.ShipPlacementRequest;
import enums.ShipTypes;

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

            ShipTypes type;
            if(ips[0].charAt(0)=='Q')
                type=ShipTypes.Q;
            else
                type=ShipTypes.P;

            int dim2 = Integer.parseInt(ips[1]);
            int dim1 = Integer.parseInt(ips[2]);

            //FOR PLAYER 1
            int x1=((int)(ips[3].charAt(0)-'A'));
            int y1=((int)(ips[3].charAt(1)-'1'));
            // doubt regarding making of new Cell
            ShipPlacementRequest plyr1 = new ShipPlacementRequest(type,dim1,dim2,new Cell(x1,y1));
            PlacmentsP1.add(plyr1);

            //FOR PLAYER 2
            int x2=((int)(ips[4].charAt(0)-'A'));
            int y2=((int)(ips[4].charAt(1)-'1'));
            ShipPlacementRequest plyr2 = new ShipPlacementRequest(type,dim1,dim2,new Cell(x2,y2));
            PlacmentsP2.add(plyr2);
        }

        //FOR PLAYER 1
        String P1= br.readLine().trim();
        String[] p1 = P1.split("\\s");
        ArrayList<Cell>allGuessesP1=new ArrayList<>();
        for(String s:p1)
        {
            Cell temp=new Cell(((int)(s.charAt(0)-'A')),((int)(s.charAt(1)-'1')),s);
            allGuessesP1.add(temp);
        }

        //FOR PLAYER 2
        String P2= br.readLine().trim();
        String[] p2 = P2.split("\\s");
        ArrayList<Cell>allGuessesP2=new ArrayList<>();
        for(String s:p2)
        {
            Cell temp=new Cell(((int)(s.charAt(0)-'A')),((int)(s.charAt(1)-'1')),s);
            allGuessesP2.add(temp);
        }

        //System.out.println(PlacmentsP1.get(0).getHeight());
        //System.out.println(PlacmentsP1.get(1).getHeight());

        Game newGame=new Game();
        newGame.gameInit(nRows,nCols,PlacmentsP1,PlacmentsP2,allGuessesP1,allGuessesP2);

    }
}
