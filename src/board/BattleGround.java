package board;
import common.ShipPlacementRequest;
import ship.Ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleGround {

    final int numRows;
    final int numCols;

    Cell Ground[][];

    public BattleGround(int nr,int nc)
    {
        this.numRows=nr;
        this.numCols=nc;

        Ground=new Cell[nr][nc];
        for(int i=0;i<nr;i++)
        {
            for(int j=0;j<nc;j++)
            {
                StringBuilder name=new StringBuilder("");
                name.append((char)('A'+i));
                name.append(String.valueOf(j+1));
                Ground[i][j]=(new Cell(i,j,name.toString()));
            }
        }
    }


    public Cell getCurrCell(int row, int col){
        return Ground[row][col];
    }


    public List<Cell> placeShip(ShipPlacementRequest placementRequest) {

        Cell startingPoint = placementRequest.getStartingPoint();
        int width = placementRequest.getWidth();
        int height = placementRequest.getHeight();

        checkBounds(startingPoint, width, height);

        List<Cell>placingCells = checkCellToBeOccupied(placementRequest);
        //System.out.println(placementRequest);
        int strength = 0;

        switch (placementRequest.getShipType()) {
            case P:
                strength = 1;
                break;
            case Q:
                strength = 2;
                break;
            default:
                strength =0;
        }
        placeshipOnBoard(placingCells, strength);

       // System.out.println(placingCells);

        return placingCells;
    }

    private void checkBounds(Cell startingPoint, int width, int height) {

       // System.out.println(startingPoint.getRow()+" "+startingPoint.getCol());
        //System.out.println(height+" "+width);
        if(width >= numCols || height >= numRows) {
            throw new RuntimeException("ship dimension out of bounds");
        }

        if((startingPoint.getCol()-1) + width >= numCols || (startingPoint.getRow()-1) + height>= numRows) {
            throw new RuntimeException("ship cannot be placed at this cell");
        }
    }

    private List<Cell> checkCellToBeOccupied(ShipPlacementRequest placementRequest) {

        List<Cell> cellToBeOccupied = new ArrayList<>();

        Cell startingPoint = placementRequest.getStartingPoint();
        int width = placementRequest.getWidth();
        int height = placementRequest.getHeight();

       //System.out.println(startingPoint.getRow()+" "+startingPoint.getCol()+" "+height+" "+width);

        for(int i = startingPoint.getRow(); i<startingPoint.getRow()+height; i++) {
            for(int j = startingPoint.getCol(); j<startingPoint.getRow()+width; j++) {

                //System.out.println(i+" "+j);
                Cell cell = getCurrCell(i,j);

                //System.out.println(cell.isOccupied());
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
            //System.out.println(cell.getName());
            cell.occupy(strength);
        }

        //System.out.println(placingCells);


    }


}
