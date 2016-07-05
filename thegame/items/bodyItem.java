/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.items;

/**
 *
 * @author Matthew
 */
public class bodyItem extends Item{
    protected int str, agi, arm, mnd;
    protected int energy;
    protected int spd, HP;
    
    public bodyItem(){
        super("", 3);
    }
    
    public int getStr(){
        return str;
    }
    
    public int getAgi(){
        return agi;
    }
    
    public int getArm(){
        return arm;
    }
    
    public int getMnd(){
        return mnd;
    }
    
    public int getHp(){
        return HP;
    }
    
    public int getSpd(){
        return spd;
    }
    
    public int getEnergy(){
        return energy;
    }
}
