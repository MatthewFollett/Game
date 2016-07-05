/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.entities.foes;


import thegame.entities.*;
import thegame.entities.player.*;
import thegame.Skills.*;
import thegame.misc.land;
import thegame.misc.level;
import thegame.misc.point;
import thegame.Main;

/**
 *
 * @author Matthew
 */
public class Foe extends Living{
    public Foe(int level, int hp, int str, int agi, int arm, int mnd, int energy, String name, int spd){
        super(level, hp, str, agi, arm, mnd, energy, name, spd);
    }
    
    public boolean isWalkable() {
        return false;
    }
    
    public void takeAttack(Skill s){
        curHP -= s.getStr();
    }
    
    public Skill attack(){
        return new normalAttack(getStr());
    }
    
    public boolean encounter(Entity e){
        if(e == Player.getPlayer()){
            Player p = (Player) e;
            this.takeAttack(p.attack());
            return (curHP <= 0);
        }
        return false;
    }

    public void turn() {
        if(this.pos.distance(Player.getPlayer().getPosition()) > 5){
            int move = rand.nextInt(4);
            switch(move){
                case 0: Main.l.checkAndMove(pos, new point(pos.x + 1, pos.y), this);
                break;
                
                case 1: Main.l.checkAndMove(pos, new point(pos.x, pos.y + 1), this);
                break;
                
                case 2: Main.l.checkAndMove(pos, new point(pos.x - 1, pos.y), this);
                break;
                
                case 3: Main.l.checkAndMove(pos, new point(pos.x, pos.y - 1), this);
                break;
            }
            return;
        }
        point p = pos.fastestPathTo(Player.getPlayer().getPosition());
        if(p != null){
            Main.l.checkAndMove(pos, p, this);
        }else{
            int move = rand.nextInt(4);
            switch(move){
                case 0: Main.l.checkAndMove(pos, new point(pos.x + 1, pos.y), this);
                break;
                
                case 1: Main.l.checkAndMove(pos, new point(pos.x, pos.y + 1), this);
                break;
                
                case 2: Main.l.checkAndMove(pos, new point(pos.x - 1, pos.y), this);
                break;
                
                case 3: Main.l.checkAndMove(pos, new point(pos.x, pos.y - 1), this);
                break;
            }
            return;
        }
    }
    
    public int getExp(){
        return 5;
    }
}
