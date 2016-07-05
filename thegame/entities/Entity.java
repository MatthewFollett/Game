package thegame.entities;

import thegame.misc.point;
import thegame.Skills.*;

abstract public class Entity {
    public char rep;
    public point pos;
    public double[] elemStr = {1,1,1,1,1};
    
    public final int PHYSICAL = 0;
    public final int FIRE = 1;
    public final int WATER = 2;
    public final int WIND = 3;
    public final int EARTH = 4;
    public int level;
    
    
    
    public Entity(){
    }
    
    public char getRep(){
        return rep;
    }
    
    public int getLevel(){
        return level;
    }
    
    public abstract boolean isWalkable();
    
    public point getPosition(){
        return pos;
    }
    
    public void setPosition(point p){
        pos = p;
    }
    
    public abstract void takeAttack(Skill s);
    
    public abstract boolean encounter(Entity e);
    
    public void setRep(char rep){
        this.rep = rep;
    }
    
    public void heal(int strength){}
}
