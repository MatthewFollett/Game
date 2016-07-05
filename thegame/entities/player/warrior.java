package thegame.entities.player;

/**
 * @author Matthew
 */
public class warrior extends Player{ 
    int START_HP = 45;
    int START_STR = 9;
    int START_AGI = 2;
    int START_ARM = 10;
    int START_MND = 1;
    int START_ENERGY = 3;
    int START_SPD = 10;
    
    public warrior(String name){
//      super(LEVEL1, START_HP, START_STR, START_AGI, START_ARM, START_MND, START_ENERGY, name, START_SPD);
        super(1, 45, 9, 2, 10, 1, 3, name, 10);
    }
}
