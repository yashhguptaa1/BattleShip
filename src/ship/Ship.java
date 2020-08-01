package ship;
import java.util.ArrayList;

public abstract class Ship {

    char type;
    int strength;
    String startingPoint;
    ArrayList<ArrayList<Integer>> ShipCoords;

    Ship()
    {

    }

    public Ship(String startingPoint, ArrayList<ArrayList<Integer>> shipCoords) {
        this.startingPoint = startingPoint;
        ShipCoords = shipCoords;
    }

    public void addCoordToList(int x,int y)
    {
        ArrayList<Integer>temp=new ArrayList<>();
        temp.add(x);
        temp.add(y);

        this.ShipCoords.add(temp);
    }

    public boolean isSunk() {
        return true;
    }

    public void occupiedOrNot()
    {

    }

    abstract public void setType();
    abstract public void setStrength();

}
