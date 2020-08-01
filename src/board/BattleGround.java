package board;
import java.util.ArrayList;

public class BattleGround {

    int numRows;
    int numCols;

    ArrayList<ArrayList<Cell>>Ground;

    BattleGround(int nr,int nc)
    {
        Ground=new ArrayList<>();
        for(int i=0;i<nr;i++)
        {
            ArrayList<Cell>temp=new ArrayList<>();
            for(int j=0;j<nc;j++)
            {
                temp.add(new Cell('#',0,"#",false));
            }
            Ground.add(temp);
        }
    }

    public Cell getCurrCell(int row,int col){
        return Ground.get(row).get(col);
    }

    public int getVal(int row,int col)
    {
        Cell curr=Ground.get(row).get(col);
        return curr.value;

    }
    public void setVal(int row,int col){

        Cell curr=Ground.get(row).get(col);
        curr.value--;
        Ground.get(row).set(col,curr);

    }

    public boolean MakeHit(String guess)
    {
        int row=(int)(guess.charAt(0));
        int col=(int)(guess.charAt(1));

        int currCellVal=getVal(row,col);

        if(currCellVal<=0)
            return false;

        setVal(row,col);
        return true;

    }



}
