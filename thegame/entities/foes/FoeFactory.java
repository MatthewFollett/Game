/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.entities.foes;

/**
 *
 * @author Matthew
 */
public class FoeFactory {

    public static Foe makeFoe(int lvl){
//      super(START_HP, START_STR, START_AGI, START_ARM, START_MND, START_ENERGY, name, START_SPD);
        Foe f = new Foe(1, 30, 5, 10, 6, 3, 5, "Goblin", 20);
        f.setRep('g');
        return f;
    }
}
