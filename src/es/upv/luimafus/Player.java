package es.upv.luimafus;

/**
 * Created by Luis on 01/11/2014.
 */
public class Player {

    private int x;
    private int y;

    private int HP = 100;
    private int currentHP = 100;

    private int defense = 20;

    private int attack = 20;

    private int shooting = 20;

    private int magic = 20;

    private Map map;

    private String ID;

    private static int n_players = 0;

    public Player(Map map) {
        this.map = map;
        setStartPos(map);
        n_players++;
        ID = "" + (char) (n_players - 1 + 'A');
    }

    private void setStartPos(Map map) {
        x = (int) (Math.random() * map.getWidth());
        y = (int) (Math.random() * map.getHeight());
    }

    public void move(char c) {
        int pX = x;
        int pY = y;

        switch (c) {
            case 'w': {
                pY--;
                break;
            }
            case 's': {
                pY++;
                break;
            }
            case 'd': {
                pX++;
                break;
            }
            case 'a': {
                pX--;
                break;
            }
        }
        map.movePlayer(this, pX, pY);
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getID() {
        return ID;
    }
}
