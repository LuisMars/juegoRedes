package es.upv.luimafus;

public class Attack {
    protected int x;
    protected int y;
    protected int time;
    protected int direction;
    protected int damage;
    protected char father;

    public Attack(int x, int y, char ID) {
        this.x = x;
        this.y = y;
        this.father = ID;
        direction = -1;
        time = 3;
        damage = 1;
    }

    public Attack(int x, int y, int dir, char ID) {
        this.x = x;
        this.y = y;
        this.father = ID;
        direction = (dir-34)%4;
        time = 5;
        damage = 2;
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

    public int getDamage() {
        return damage;
    }

    public char getFather() {
        return father;
    }
}
