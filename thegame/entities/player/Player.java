package thegame.entities.player;

import thegame.entities.*;
import thegame.Skills.*;
import thegame.items.*;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import thegame.misc.level;
import thegame.misc.point;
import thegame.Main;
import thegame.entities.foes.Foe;

abstract public class Player extends Living{
    static Player p;
    HashMap<String, Item> inventory;
    HashMap<String, Skill> skillSet;
    BufferedReader br;
    int exp;
    
    public Player(int level, int hp, int str, int agi, int arm, int mnd, int energy, String name, int spd){
        super(level, hp, str, agi, arm, mnd, energy, name, spd);
        exp = 0;
        rep = 'P';
        p = this;
        inventory = new HashMap<String, Item>();
        skillSet = new HashMap<String, Skill>();
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public boolean isWalkable(){
        return false;
    }
    
    public boolean encounter(Entity e){
        Foe f = (Foe) e;
        this.takeAttack(f.attack());
        System.out.println(curHP);
        return (curHP <= 0);
    }
    
    public void takeDamage(Skill s){
    }
    
    public static Player getPlayer(){
        return p;
    }
    
    public void addItem(Item i){
        if(inventory.containsKey(i.getName())){
            inventory.get(i.getName()).add(i.getQuant());
        }
        else{
            inventory.put(i.getName(), i);
        }
    }
    
    public String toString(){
        return inventory.values().toString() + "\r\nLevel:" + level + "  HP: " + getCurHP() + " / " + getHP() + "  EXP: " + exp;
    }
    
    public Skill attack(){
        return new normalAttack(getStr());
    }
    
    public int getStr(){
        return str;
    }
    
    public int getMnd(){
        return mnd;
    }
    
    public int getCurHP(){
        return curHP;
    }
    
    public int getHP(){
        return hp;
    }
    
    public void takeAttack(Skill s){
            curHP -= s.getStr();
        System.out.println("Taken " + s.getStr() + " worth of damage!");}
    
    public void turn(){
        System.out.println("Dungeon Floor - " + Main.l.levelValue + Main.l.foeList.size());
        Main.l.printLevel();
        System.out.println(p.toString());
        System.out.println("Co-ords: " + p.getPosition());
        System.out.println("Your Move: ");
        String cmd;
        try{
            cmd = br.readLine();
        }
        catch(Exception e){return;}
        if (cmd.length() == 0) {
            return;
        }
        char c = Character.toUpperCase(cmd.charAt(0));
        point po;
        switch (c) {
            case 'N':
                if (Main.l.validMove(po = new point(p.getPosition().x, p.getPosition().y - 1))) {
                    Main.l.checkAndMove(p.getPosition(), po, this);
                }
            break;
            case 'S':
                if (Main.l.validMove(po = new point(p.getPosition().x, p.getPosition().y + 1))) {
                    Main.l.checkAndMove(p.getPosition(), po, this);
                }
            break;
            case 'E':
                if (Main.l.validMove(po = new point(p.getPosition().x + 1, p.getPosition().y))) {
                    Main.l.checkAndMove(p.getPosition(), po, this);
                }
            break;
            case 'W':
                if (Main.l.validMove(po = new point(p.getPosition().x - 1, p.getPosition().y))) {
                    Main.l.checkAndMove(p.getPosition(), po, this);
                }
            break;
            case 'U':
                level tmp = Main.l.getPrevLevel();
                if(tmp != null){
                    Main.l.area[p.getPosition().x][p.getPosition().y].thing = null;
                    Main.l.area[p.getPosition().x][p.getPosition().y].element = null;
                    Main.l = tmp;
                    pos = Main.l.finish.copy();
                    Main.l.area[p.getPosition().x][p.getPosition().y].thing = p;
                }
            break;
            case 'D':
                tmp = Main.l.getNextLevel();
                if(tmp != null){
                    Main.l.area[p.getPosition().x][p.getPosition().y].thing = null;
                    Main.l.area[p.getPosition().x][p.getPosition().y].element = null;
                    Main.l = tmp;
                    pos = Main.l.start.copy();
                    Main.l.area[p.getPosition().x][p.getPosition().y].thing = p;
                }
            break;
        }
    }
    
    public void addExp(int exp){
        this.exp = exp;
    }
}
