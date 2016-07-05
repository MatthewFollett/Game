/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.Skills;

import thegame.Main;
import thegame.entities.Entity;
import thegame.entities.Living;
import thegame.misc.point;

/**
 *
 * @author Matthew
 */

public class moveSkill extends Living{
    int speed;
    int dx, dy;
    int totSpd;
    char rep;
    Entity origin;
    
    public moveSkill(Entity origin, String name, int spd){
        super(origin.getLevel(), 1, 1, 1, 1, 1, 1, name, spd);
        this.dx = dx;
        this.dy = dy;
        totSpd = 0;
        this.rep = rep;
        this.origin = origin;
    }
    
    public boolean encounter(Entity e){
        if(e != origin){
            
        }
        return true;
    }

    public boolean isWalkable() {
        return false;
    }

    public void takeAttack(Skill s) {
    }

    @Override
    public void turn() {
        Main.l.checkAndMove(pos, new point(pos.x +dx, pos.y - dy), this);
    }

}
