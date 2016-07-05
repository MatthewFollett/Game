package thegame;

import thegame.misc.*;
import thegame.entities.player.*;

import java.io.*;

public class Main {
    
    public static level l;

    public static void main(String[] args) throws IOException {
        l = new level(1, .45);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is thousts name? ");
//        String name = br.readLine();
        String name = "Matthew";
        System.out.println("Are thoust a (W)arrior, a (R)ogue, or a (M)age? ");
//      String clas = br.readLine();
        String clas = "M";
        Player p = PlayerFactory.makePlayer(name, clas);
        while (p == null) {
            System.out.println("Thoust is trying to lies about thie's carrer.");
            System.out.println("I will ask again;");
            System.out.println("Are thoust a (W)arrior, a (R)ogue, or a (M)age? ");
            clas = br.readLine();
            p = PlayerFactory.makePlayer(name, clas);
        }
        p.setPosition(l.start.copy());
        l.area[p.getPosition().x][p.getPosition().y].thing = p;
        while (true) {
            for(int i = 0; i < l.foeList.size(); i++){
                l.foeList.get(i).addTotSpd(l.foeList.get(i).getSpd());
                if(l.foeList.get(i).getTotSpd() >= 100){
                    l.foeList.get(i).turn();
                    l.foeList.get(i).addTotSpd(-100);
                }
            }
            p.addTotSpd(p.getSpd());
            if(p.getTotSpd() >= 100){
                p.turn();
                p.addTotSpd(-100);
            }
/*            System.out.println("Co-ords: " + p.getPosition());
            System.out.println("Your Move: ");
            String cmd = br.readLine();
            if (cmd.length() == 0) {
                continue;
            }
            char c = Character.toUpperCase(cmd.charAt(0));
            point po;
            switch (c) {
                case 'N':
                    if (l.validMove(po = new point(p.getPosition().x, p.getPosition().y - 1))) {
                        l.checkAndMove(p.getPosition(), po);
                    }
                break;
                case 'S':
                    if (l.validMove(po = new point(p.getPosition().x, p.getPosition().y + 1))) {
                        l.checkAndMove(p.getPosition(), po);
                    }
                break;
                case 'E':
                    if (l.validMove(po = new point(p.getPosition().x + 1, p.getPosition().y))) {
                        l.checkAndMove(p.getPosition(), po);
                    }
                break;
                case 'W':
                    if (l.validMove(po = new point(p.getPosition().x - 1, p.getPosition().y))) {
                        l.checkAndMove(p.getPosition(), po);
                    }
                break;
                case 'U':
                    level tmp = l.getPrevLevel();
                    if(tmp != null){
                        l.area[p.getPosition().x][p.getPosition().y].thing = null;
                        l.area[p.getPosition().x][p.getPosition().y].element = null;
                        l = tmp;
                        p.setPosition(l.finish.copy());
                        l.area[p.getPosition().x][p.getPosition().y].thing = p;
                    }
                break;
                case 'D':
                    tmp = l.getNextLevel();
                    if(tmp != null){
                        l.area[p.getPosition().x][p.getPosition().y].thing = null;
                        l.area[p.getPosition().x][p.getPosition().y].element = null;
                        l = tmp;
                        p.setPosition(l.start.copy());
                        l.area[p.getPosition().x][p.getPosition().y].thing = p;
                    }
                break;
            }
            System.out.println("Dungeon Floor - " + l.levelValue);
            l.printLevel();
            System.out.println(p.toString());*/
        }
    }
}
