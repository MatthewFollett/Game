/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.entities.player;

/**
 *
 * @author Matthew
 */
public class PlayerFactory {
    public static Player makePlayer(String name, String clas){
        if(clas.toLowerCase().equals("warrior") || clas.toLowerCase().equals("w")){
            return new warrior(name);
        }
        if(clas.toLowerCase().equals("rogue") || clas.toLowerCase().equals("r")){
            return new rogue(name);
        }
        if(clas.toLowerCase().equals("mage") || clas.toLowerCase().equals("m")){
            return new mage(name);
        }
        else{
            return null;
        }   
    }
}
