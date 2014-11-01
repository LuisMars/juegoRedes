package es.upv.luimafus;

/**
 * Created by Luis on 01/11/2014.
 */
public class Player {

    private int x;
    private int y;
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
        x = (int) (Math.random() * map.getWidth()) + 1;
        y = (int) (Math.random() * map.getHeight()) + 1;
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
        if (map.canMove(pX, pY)) {
            x = pX;
            y = pY;
        }

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
