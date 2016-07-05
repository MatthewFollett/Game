package thegame.misc;

import java.util.ArrayList;
import thegame.Main;

public class point {
    public int x, y;
    
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public boolean equals(point p){
        return x == p.x && y == p.y;
    }
    
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    
    public point copy(){
        return new point(x, y);
    }
    
    public point fastestPathTo(point p1){
        ArrayList<searchPair> al = new ArrayList<searchPair>();
        ArrayList<point> history = new ArrayList<point>();
        al.add(new searchPair(new point(x + 1, y), new point(x + 1, y)));
        al.add(new searchPair(new point(x, y + 1), new point(x, y + 1)));
        al.add(new searchPair(new point(x - 1, y), new point(x - 1, y)));
        al.add(new searchPair(new point(x, y - 1), new point(x, y - 1)));
        history.add(this);
        
        while(al.size() != 0){
            searchPair sp = al.remove(0);
            if(sp.p1.equals(p1)){
                return sp.p;
            }
            if(Main.l.validMove(sp.p1)){
                boolean histTest = true;
                for(int i = 0; i < history.size(); i++){
                    if(history.get(i).equals(sp.p1)){
                        histTest = false;
                        break;
                    }
                }
                if(histTest){
                    history.add(sp.p1);
                    al.add(new searchPair(sp.p, new point(sp.p1.x + 1, sp.p1.y)));
                    al.add(new searchPair(sp.p, new point(sp.p1.x, sp.p1.y + 1)));
                    al.add(new searchPair(sp.p, new point(sp.p1.x - 1, sp.p1.y)));
                    al.add(new searchPair(sp.p, new point(sp.p1.x, sp.p1.y - 1)));
                }                        
            }
        }
        return null;
    }
    
    public int distance(point p){
        return Math.abs(p.x - x) + Math.abs(p.y - y);
    }
    
    private class searchPair{
        public point p;
        public point p1;
        
        public searchPair(point p, point p1){
            this.p = p;
            this.p1 = p1;
        }
    }
}
