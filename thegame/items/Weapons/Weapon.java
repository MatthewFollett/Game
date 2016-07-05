/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.items.Weapons;
import thegame.items.Item;
import java.util.Random;
/**
 *
 * @author Matthew
 */
abstract public class Weapon extends Item{
    
    protected int str, agi, arm, mnd;
    protected int energy;
    protected int spd, HP;
    protected int maxDmg, minDmg;
    Random rand;
    
    public Weapon(){
        super("", 3);
        rand = new Random();
    }
    
    public int getDamage(){
        return rand.nextInt(minDmg - maxDmg) + minDmg;
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
