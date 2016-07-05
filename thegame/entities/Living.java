package thegame.entities;

import thegame.misc.land;
import thegame.misc.level;
import java.util.Random;

abstract public class Living extends Entity{
    protected int hp, curHP;
    protected int str, agi, arm, mnd;
    protected int energy, curEnergy;
    protected String name;
    protected int spd, totSpd;
    protected int level;
    protected static Random rand = new Random();
    
    public Living(int level, int hp, int str, int agi, int arm, int mnd, int energy, String name, int spd){
        this.level = level;
        this.hp = hp;
        this.curHP = hp;
        this.str = str;
        this.agi = agi;
        this.arm = arm;
        this.mnd = mnd;
        this.energy = energy;
        this.curEnergy = energy;
        this.name = name;
        this.spd = spd;
        totSpd = rand.nextInt(100);
    }
    public void heal(int val){
        curHP = curHP + val;
        if(curHP > hp){
            curHP = hp;
        }
    }
    
    public void damage(int dmg){
        curHP -= dmg;
    }
    
    public int getArmor(){
        return arm;
    }
    
    public int getSpd(){
        return spd;
    }
    
    public int getStr(){
        return str;
    }
    
    public int getTotSpd(){
        return totSpd;
    }
    
    public void addTotSpd(int s){
        totSpd += s;
    }
    
    abstract public void turn();
}
