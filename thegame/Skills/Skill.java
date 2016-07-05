/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.Skills;

/**
 *
 * @author Matthew
 */
public abstract class Skill {
    public static final int PHYSICAL = 0;
    public static final int FIRE = 1;
    public static final int WATER = 2;
    public static final int WIND = 3;
    public static final int EARTH = 4;
    
    int type;
    int str;
    
    public Skill(int type, int str){
        this.type = type;
        this.str = str;
    }
    
    public int getStr(){
        return str;
    }
    
}
