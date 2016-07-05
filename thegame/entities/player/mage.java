/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.entities.player;

import thegame.Skills.*;


public class mage extends Player{
    int START_HP = 20;
    int START_STR = 2;
    int START_AGI = 3;
    int START_ARM = 4;
    int START_MND = 9;
    int START_ENERGY = 20;
    int START_SPD = 13;
    
    public mage(String name){
//      super(START_HP, START_STR, START_AGI, START_ARM, START_MND, START_ENERGY, name, START_SPD);
        super(1, 20, 2, 3, 4, 9, 20, name, 13);
    }
    
    public Skill attack(){
        return new normalAttack(getMnd());
    }
}
