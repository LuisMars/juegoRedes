package es.upv.luimafus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 01/11/2014.
 */
public class Map {
    private static int[][] map;
    private static List<Player> players = new ArrayList<Player>();
    public static Player cPlayer;

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
        cPlayer = players.iterator().next();
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
                if(j == map.length)
                    continue;
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

    public static void move(char c) {
        cPlayer.move(c);
        cPlayer = nextPlayer();
    }

    public static Player nextPlayer() {
        return players.get((players.indexOf(cPlayer)+1)%players.size());
    }
}
