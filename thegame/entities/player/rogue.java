/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.entities.player;


public class rogue extends Player{    
    int START_HP = 30;
    int START_STR = 5;
    int START_AGI = 10;
    int START_ARM = 6;
    int START_MND = 3;
    int START_ENERGY = 5;
    int START_SPD = 13;
    
    public rogue(String name){
//      super(START_HP, START_STR, START_AGI, START_ARM, START_MND, START_ENERGY, name, START_SPD);
        super(1, 30, 5, 10, 6, 3, 5, name, 13);
    }
}
