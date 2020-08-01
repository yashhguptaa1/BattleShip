package board;
import common.ShipPlacementRequest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleGround {

    int numRows;
    int numCols;

    Cell Ground[][];

    public BattleGround(int nr,int nc)
    {

        Ground=new Cell[nr][nc];
       // Ship= new Ship();
        for(int i=0;i<nr;i++)
        {
            for(int j=0;j<nc;j++)
            {
                Ground[i][j]=(new Cell());
            }
        }
    }

    public Cell getCurrCell(int row,int col){
        return Ground[row][col];
    }

    public int getVal(int row,int col)
    {
        Cell curr=Ground[row][col];
        return curr.value;

    }
    public void setVal(int row,int col){

        Cell curr=Ground[row][col];
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

    public void placeShip(ShipPlacementRequest placementRequest) {

        Cell startingPoint = placementRequest.getStartingPoint();
        int width = placementRequest.getWidth();
        int height = placementRequest.getHeight();

        checkBounds(startingPoint, width, height);

        List<Cell>placingCells = checkCellToBeOccupied(placementRequest);
        int strength = 0;

        switch (placementRequest.getShipType()) {
            case 1:
                strength = 1;
                break;
            case 2:
                strength = 2;
                break;
            default:
                strength =0;
        }
        placeshipOnBoard(placingCells, strength);
    }

    private void checkBounds(Cell startingPoint, int width, int height) {

        if(width >= numCols || height >= numRows) {
            throw new RuntimeException("ship dimension out of bounds");
        }

        if(startingPoint.getCol() + width >= numCols || startingPoint.getRow() + height>= numRows) {
            throw new RuntimeException("ship cannot be placed at this cell");
        }
    }

    private List<Cell> checkCellToBeOccupied(ShipPlacementRequest placementRequest) {

        List<Cell> cellToBeOccupied = new ArrayList<>();

        Cell startingPoint = placementRequest.getStartingPoint();
        int width = placementRequest.getWidth();
        int height = placementRequest.getHeight();

        for(int i = startingPoint.getRow(); i< height; i++) {
            for(int j = startingPoint.getCol(); j<width; j++) {
                Cell cell = Ground[i][j];

                if(cell.isOccupied()) {
                    throw new RuntimeException("cell is occupied so ship can't be placed");
                } else {
                    cellToBeOccupied.add(cell);
                }
            }
        }

        return cellToBeOccupied;
    }

    private void placeshipOnBoard(List<Cell> placingCells, int strength) {

        Iterator it = placingCells.iterator();

        while (it.hasNext()) {
            Cell cell = (Cell) it.next();
            cell.occupy(strength);
        }
    }

}
