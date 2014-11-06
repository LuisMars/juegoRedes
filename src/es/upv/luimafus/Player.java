package es.upv.luimafus;

import java.awt.event.KeyEvent;

/**
 * Created by Luis on 01/11/2014.
 */
public class Player {

    private int x;
    private int y;

    private int reloadTime = 2;

    private int lastAtt = 0;


    private int lastDir = 0;

    private Area area = new Area();

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
                lastDir = 0;
                break;
            }
            case 's': {
                pY++;
                lastDir = 2;
                break;
            }
            case 'd': {
                pX++;
                lastDir = 1;
                break;
            }
            case 'a': {
                pX--;
                lastDir = 3;
                break;
            }
        }
        map.movePlayer(this, pX, pY);
    }

    public void attack(int direction) {
        if((int)(System.currentTimeMillis()/100) - lastAtt > reloadTime) {

            lastAtt = (int)(System.currentTimeMillis()/100);
            if(direction == -1)
                area = new Area(x, y);
            else
                Map.addAttack(new Attack(x, y, direction));
        }
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

    public void updateArea() {
        area.updatePos();
    }
}
