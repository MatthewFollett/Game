package thegame.misc;
import thegame.entities.*;

public class land {
    public boolean walkable;
    public Living thing;
    public LandEnt element;
    char rep ;
    
    public land(){
        walkable = false;
        thing = null;
        rep = '|';
    }
    
    public void setWalkable(boolean b){
        walkable = b;
    }

    public boolean isWalkable(){
        return walkable;
    }
    
    public char getRep(){
        if (thing == null)
            if(element != null && element.visible){
                return element.getRep();
            }
            else{
                return rep;
            }
        else
            return thing.getRep();
    }
}
