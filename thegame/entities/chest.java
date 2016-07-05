package thegame.entities;

import thegame.items.*;
import thegame.entities.player.Player;
import thegame.Skills.*;
/**
 *
 * @author Matthew
 */
public class chest extends LandEnt{
    Item i;
    
    public chest(Item i){
        super();
        this.i = i;
        visible = true;
        rep = 'C';
    }
    
    public char getRep(){
        return rep;
    }
    
    public boolean isWalkable(){
        return true;
    }

    @Override
    public boolean encounter(Entity e) {
        Player p = (Player)e;
        p.addItem(i);
        return true;
    }
    
    public void takeAttack(Skill s){}
}
