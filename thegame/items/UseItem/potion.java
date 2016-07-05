package thegame.items.UseItem;

import thegame.entities.Entity;

/**
 *
 * @author Matthew
 */
public class potion extends UseItem{
    int strength;
    public potion(String name, int num){
        super(name, num);
	dice.misc.dice.misc.dice d = new dice.misc.dice(30);
        this.strength = d.getRandomRoll();
    }
    
    @Override
    void use(Entity target) {
        target.heal(strength);
    }
}
