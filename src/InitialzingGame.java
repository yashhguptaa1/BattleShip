import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InitialzingGame {

    public static void main(String[] args)  throws IOException {

        File file = new File("C:\\Users\\yashh\\Desktop\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String firstLine = br.readLine().trim();
        String[] first = firstLine.split("\\s");
        int nRows=Integer.parseInt(first[0]);
        int nCols=(int)(first[1].charAt(0)-'A')+1;

        System.out.println(nRows +" "+nCols );

        BattleGround bg1=new BattleGround(nRows,nCols);
        HashMap<String,Integer>h1=new HashMap<>();

        BattleGround bg2=new BattleGround(nRows,nCols);
        HashMap<String,Integer>h2=new HashMap<>();

        int numofships=Integer.parseInt(br.readLine().trim());

        while(numofships-- >0)
        {
            String ipLine = br.readLine().trim();
            String[] ips = ipLine.split("\\s+");

            char type=ips[0].charAt(0);
            int val=0;
            if(type=='Q')
                val=2;
            else
                val=1;
            int dim1=Integer.parseInt(ips[1]);
            int dim2=Integer.parseInt(ips[2]);

            //FOR PLAYER 1
            int AstartX=(int)(ips[3].charAt(0)-'0');
            int AstartY=(int)ips[3].charAt(1);

            for(int i=AstartX;i<=dim1;i++)
            {
                for(int j=AstartY;j<=dim2;j++)
                {
                    Cell curr=bg1.getCurrCell(i,j);
                    curr.setType(type);
                    curr.setValue(val);
                    curr.setOccupied(true);
                    curr.setStartingPoint(ips[3]);
                }
            }

            h1.put(ips[3],dim1*dim2*val);

            //FOR PLAYER 2
            int BstartX=(int)(ips[4].charAt(0)-'0');
            int BstartY=(int)ips[4].charAt(0);

            for(int i=BstartX;i<=dim1;i++)
            {
                for(int j=BstartY;j<=dim2;j++)
                {
                    Cell curr=bg2.getCurrCell(i,j);
                    curr.setType(type);
                    curr.setValue(val);
                    curr.setOccupied(true);
                    curr.setStartingPoint(ips[4]);
                }
            }
            h2.put(ips[4],dim1*dim2*val);
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

        System.out.println(allGuessesP1);
        System.out.println(allGuessesP2);

        Game newGame=new Game(4,bg1,bg2,h1,h2,allGuessesP1,allGuessesP2);
        newGame.start();

    }
}
