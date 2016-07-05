/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame.items;

import thegame.entities.*;

/**
 *
 * @author Matthew
 */
abstract public class Item {
    protected String name;
    protected int quant;
    
    public Item(String name, int num){
        this.name = name;
        quant = num;
    }
    
     public String getName(){
        return name;
    }
    
    public void add(int i){
        quant = quant + i;
    }
    
    public int getQuant(){
        return quant;
    }
}
