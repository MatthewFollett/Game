/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.items.UseItem;
import thegame.items.Item;
import thegame.entities.*;
/**
 *
 * @author Matthew
 */
abstract class UseItem extends Item{
    
    public UseItem(String name, int num){
        super(name, num);
    }
    
    abstract void use(Entity target);
    
    public String toString(){
        return name + " x " + quant;
    }
}
