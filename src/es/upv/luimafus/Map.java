package es.upv.luimafus;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Luis on 01/11/2014.
 */
public class Map {
    private static int[][] map;
    private static List<Player> players = new ArrayList<Player>();
    private static Collection<Attack> attacks = new ArrayList<Attack>();
    public static Player cPlayer;

    public Map(int h, int w, double density) {
        map = new int[h][w];
        generateMap(density);
    }

    public void generateMap(double density) {
        for (int i = 0; i < map[i].length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[j][i] = 1;
            }
        }
        double area = getHeight() * getWidth() * density;
        double covered = 0;
        while (area > covered) {

            int iy = (int)(Math.random() * getWidth());
            int fy = 0;
            while (fy < iy)
                fy = (int)(Math.random() * getWidth());

            int ix = (int)(Math.random() * getHeight());
            int fx = 0;
            while (fx < ix)
                fx = (int)(Math.random() * getHeight());

            boolean overlaps = false;
            for (int i = ix; i < fx; i++) {
                for (int j = iy; j < fy; j++) {
                    if(map[j][i] == 0)
                        overlaps = true;
                }
            }

            if(overlaps)
                continue;

            for (int i = ix; i < fx; i++) {
                for (int j = iy; j < fy; j++) {
                    map[j][i] = 0;
                }
            }
            covered = 0;
            for (int i = 0; i < map[i].length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if(map[j][i] == 0)
                        covered++;
                }
            }
            System.out.println("Area: " + area + " Covered: " + covered);
        }
    }

    public void addPlayer(Player p) {
        players.add(p);
        cPlayer = players.iterator().next();
    }

    public static void addAttack(Attack a) {
        attacks.add(a);
    }

    public String toString() {
        String res = "";
        String cell;

        for (Player p : players)
            p.updateArea();

        for (Attack a: attacks) {
            a.updatePos();
        }

        for (int i = 0; i < map[i].length; i++) {
            for (int j = 0; j < map.length; j++) {
                cell = "";
                for (Player p : players)
                    if (p.getX() == j && p.getY() == i) {
                        cell = p.getID() + " ";
                    }

                for (Attack a: attacks) {
                    if (!a.isOver() && a.getX() == j && a.getY() == i) {
                        if (map[j][i] == 1) {
                            a.kill();
                        }
                        cell = a.getID() + " ";
                    }
                }
                if(cell.isEmpty())
                    cell = (map[j][i] == 1 ? "· " : "  ");
                res += cell;
            }
            res += "\n";
        }
        attacks.removeIf(Attack::isOver);
        return res;
    }

    public static int getWidth() {
        return map.length;
    }

    public static int getHeight() {
        return map[0].length;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void movePlayer(Player p, int x, int y) {
        if(canMove(x, y))
            p.moveTo(x,y);
    }

    public boolean canMove(int x, int y) {
        for(Player p : players) {
            if(p.getX() == x && p.getY() == y)
                return false;
        }
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length)
            return false;
        return map[x][y] == 0;
    }

    public static void act(KeyEvent e) {
        if(e.getKeyChar() == ' ')
            cPlayer.attack(-1);
        else if(!e.isActionKey())
            cPlayer.move(e.getKeyChar());
        else
            cPlayer.attack(e.getKeyCode());
        cPlayer = nextPlayer();
    }

    public static Player nextPlayer() {
        return players.get((players.indexOf(cPlayer)+1)%players.size());
    }


}
