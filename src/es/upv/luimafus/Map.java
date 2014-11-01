package es.upv.luimafus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 01/11/2014.
 */
public class Map {
    private int[][] map;
    private List<Player> players = new ArrayList<Player>();

    public Map(int h, int w, double density) {
        map = new int[h][w];
        generateMap(density);
    }

    public void generateMap(double density) {
        for (int i = 0; i < map[i].length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[j][i] = Math.random() < density ? 1 : 0;
            }
        }
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < map[i].length; i++) {
            for (int j = 0; j < map.length; j++) {
                for (Player p : players)
                    if (p.getX() == j && p.getY() == i) {
                        res += p.getID() + " ";
                        j++;
                    }
                res += (map[j][i] == 1 ? "#" : ".");
                res += " ";
            }
            res += "\n";
        }
        return res;
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean canMove(int x, int y) {
        return map[x][y] == 0;
    }
}
