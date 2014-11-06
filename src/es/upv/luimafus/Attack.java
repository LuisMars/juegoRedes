package es.upv.luimafus;

/**
 * Created by Luis on 05/11/2014.
 */
public class Attack {
    protected int x;
    protected int y;
    protected int time;
    protected int direction;

    public Attack(int x, int y) {
        this.x = x;
        this.y = y;
        direction = -1;
        time = 4;
    }

    public Attack(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        direction = (dir-34)%4;
        time = 10;
    }

    public void updatePos() {
        if(--time >= 0 && direction != -1) {
            switch (direction) {
                case 0: {
                    y--;
                    break;
                }
                case 1: {
                    x++;
                    break;
                }
                case 2: {
                    y++;
                    break;
                }
                case 3: {
                    x--;
                    break;
                }
            }
        }
    }

    public char getID() {
        if(direction == -1)
            return ',';
        else if(direction%2 == 0)
            return '|';
        else
            return '-';
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void kill() {
        time = -1;
    }

    public boolean isOver() {
        return time < 0;
    }
}
