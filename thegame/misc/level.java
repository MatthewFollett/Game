package thegame.misc;

import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import thegame.Skills.moveSkill;
import thegame.entities.Living;
import thegame.entities.player.*;
import thegame.entities.chest;
import thegame.items.UseItem.potion;
import thegame.entities.foes.*;

public class level {
    public ArrayList<Foe> foeList;
    public ArrayList<moveSkill> skillList;
    public level nextLevel,  prevLevel;
    public land[][] area;
    public int levelValue;
    static int maxX = 30;
    static int maxY = 15;
    double MAPINDEX;
    public point start;
    public point finish;

    public level(int level, double mapindex) {
        this.foeList = new ArrayList<Foe>();
        this.MAPINDEX = mapindex;
        this.levelValue = level;
        area = new land[maxX][maxY];

        int count = generateLevel();
        while (count < 20) {
            count = generateLevel();
        }
    }

    public int generateLevel() {
        boolean[][] used = new boolean[maxX][maxY];
        Random rand = new Random();
        rand.nextInt(maxX);
        Stack<point> areaStack = new Stack<point>();
        ArrayList<point> free = new ArrayList<point>();
        start = new point(rand.nextInt(maxX), rand.nextInt(maxY));
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                area[i][j] = new land();
                used[i][j] = false;
            }
        }
        area[start.x][start.y].setWalkable(true);
        area[start.x][start.y].rep = 'S';
        used[start.x][start.y] = true;
        for (int i = -1; i <= 1; i++) {
            if ((start.x + i < maxX) && (start.x + i >= 0)) {
                for (int j = -1; j <= 1; j++) {
                    if ((start.y + j < maxY) && (start.y + j >= 0)) {
                        if (!used[start.x + i][start.y + j] && ((i + j) % 2 != 0)) {
                            areaStack.add(new point(start.x + i, start.y + j));
                        }
                    }
                }
            }
        }
        int count = 1;
        ArrayList<point> al = new ArrayList<point>();
        areaStack.add(start);
        while (!areaStack.isEmpty()) {
            point p = areaStack.pop();
            if (used[p.x][p.y]) {
                continue;
            }
            used[p.x][p.y] = true;
            if (rand.nextDouble() > MAPINDEX) {
                area[p.x][p.y].walkable = true;
                area[p.x][p.y].rep = ' ';
                al.add(p);
                free.add(p);
                ++count;
                for (int i = -1; i <= 1; i++) {
                    if (((p.x + i) < maxX) && ((p.x + i) >= 0)) {
                        for (int j = -1; j <= 1; j++) {
                            if ((p.y + j < maxY) && (p.y + j >= 0)) {
                                if (!used[p.x + i][p.y + j] && ((i + j) % 2 != 0)) {
                                    areaStack.add(new point(p.x + i, p.y + j));
                                }
                            }
                        }
                    }
                }
            }
        }
        finish = null;
        int i;
        while (al.size() > 0) {
            i = rand.nextInt(al.size());
            point p = al.get(i);
            if (Math.abs(p.x - start.x) + Math.abs(p.y - start.y) > 10) {
                finish = p;
                area[p.x][p.y].rep = 'F';
                break;
            }
            al.remove(i);
        }
        if (finish == null) {
            count = -1;
        }
        free.remove(finish);
        int numChest = rand.nextInt((int)(1.5 + ((double) free.size() / 10) ) );
        for(i = 0; i < numChest; i++){
            int j = rand.nextInt(free.size());
            point p = free.remove(j);
            area[p.x][p.y].element = new chest(new potion("+50 Potion", 3));
        }
        
        int numFoe = rand.nextInt((int)(1.5 + ((double) free.size() / 5) ) );
        for(i = 0; i < numFoe; i++){
            int j = rand.nextInt(free.size());
            point p = free.remove(j);
            Foe f = FoeFactory.makeFoe(levelValue);
            foeList.add(f);
            area[p.x][p.y].thing = f;
            f.pos = p;
        }
        return count;
    }

    public void printLevel() {
        char[][] screen = new char[maxX + 2][maxY + 2];
        // Top Border
        for (int j = 0; j < maxY + 2; j++) {
            screen[0][j] = '#';
        }
        //Level
        for (int i = 0; i < maxX; i++) {
            // Left border
            screen[i + 1][0] = '#';
            for (int j = 0; j < maxY; j++) {
                screen[i + 1][j + 1] = area[i][j].getRep();
            }
            // Bottom Border
            screen[i + 1][maxY + 1] = '#';
        }
        // Right Border
        for (int j = 0; j < maxY + 2; j++) {
            screen[maxX + 1][j] = '#';
        }
        for (int i = 0; i < screen[0].length; i++) {
            for (int j = 0; j < screen.length ; j++) {
                System.out.print(screen[j][i]);
            }
            System.out.println("");
        }
        System.out.println("Start: " + start);
        System.out.println("End: " + finish);
    }

    public boolean validMove(point p) {
        boolean b = ((p.x >= 0) && (p.x < maxX) && (p.y >= 0) && (p.y < maxY) && area[p.x][p.y].isWalkable());
        return b;
    }

    public level getNextLevel() {
        if(finish.equals(Player.getPlayer().getPosition())){
            if (nextLevel == null) {
                nextLevel = new level(levelValue + 1, MAPINDEX);
                nextLevel.prevLevel = this;
            }
            return nextLevel;
        }
        return null;
    }
    
    public boolean move(point p, Living li){
        if(validMove(p)){
            if(area[p.x][p.y].thing != null){
                if(area[p.x][p.y].thing.encounter(li)){
                    if (foeList.contains(area[p.x][p.y].thing)){
                        Foe f =  (Foe) area[p.x][p.y].thing;
                        Player.getPlayer().addExp( f.getExp() );
                        foeList.remove(f);
                    }
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(area[p.x][p.y].element != null){
                return area[p.x][p.y].element.encounter(Player.getPlayer());
            }
        }
        return validMove(p) && area[p.x][p.y].isWalkable();
    }

    public level getPrevLevel(){
        if(start.equals(Player.getPlayer().getPosition())){
            return prevLevel;
        } else {
            return null;
        }
    }
    
    public boolean checkAndMove(point p0, point p1, Living li){
        if (! move(p1, li)){
            return false;
        }
        move(p1, li);
        area[p0.x][p0.y].thing = null;
//        area[Player.getPlayer().getPosition().x][Player.getPlayer().getPosition().y].element = null;
        li.getPosition().x = p1.x;
        li.getPosition().y = p1.y;
        area[li.getPosition().x][li.getPosition().y].thing = li;
        return true;
    }
}