package es.upv.luimafus;

public class Player {


    private int x;
    private int y;

    private int lastAtt = 0;

    private int action;

    private int HP = 10;
    private int cHP = HP;

    private Area area = new Area();

    private boolean bot;

    private char ID;

    private static int n_players = 0;

    public Player(boolean b) {
        bot = b;
        setStartPos();
        n_players++;
        ID = (char)(n_players - 1 + 'A');
    }

    private void setStartPos() {
        while (Map.getCell(x, y) != 0) {
            x = (int) (Math.random() * Map.getWidth());
            y = (int) (Math.random() * Map.getHeight());
        }
    }

    public void setAction(int a) {
        switch (a) {
            case 119: {
                action = 0;
                break;
            }
            case 100: {
                action = 1;
                break;
            }
            case 115: {
                action = 2;
                break;
            }
            case 97: {
                action = 3;
                break;
            }
            case 38:
            case 39:
            case 40:
            case 37: {
                action = 4+(a-34)%4;
                break;
            }
            case 8: {
                action = 8;
                break;
            }
        }
    }

    public void act() {
        switch (action) {
            case 0:
            case 1:
            case 2:
            case 3: {
                move(action);
                break;
            }
            case 4:
            case 5:
            case 6:
            case 7: {
                attack(action-4);
                break;
            }
            case 8: {
                attack(-1);
                break;
            }
        }
        action = -1;
        lastAtt--;
    }

    public void move(int m) {
        int pX = x;
        int pY = y;

        switch (m) {
            case 0: {
                pY--;
                break;
            }
            case 2: {
                pY++;
                break;
            }
            case 1: {
                pX++;
                break;
            }
            case 3: {
                pX--;
                break;
            }
        }
        Map.movePlayer(this, pX, pY);
    }

    public void attack(int direction) {
        if(lastAtt <= 0) {
            if (direction == -1) {
                if (area.isOver()) {
                    area = new Area(x, y, ID);
                    cHP--;
                }
            }
            else
                Map.addAttack(new Attack(x, y, direction, ID));
            lastAtt = 3;
        }

    }

    public void botMove(Player p) {
        int[] best = new int[4];
        for(int i = 0; i < best.length; i++)
            best[i] = Utils.distance(getX()+Utils.dirToSumX(i),getY()+Utils.dirToSumY(i),p.getX(),p.getY());
        int min = 99999999;
        int dir = -1;
        for(int i = 0; i < best.length; i++)
            if(best[i] < min && Map.canMove(getX()+Utils.dirToSumX(i),getY()+Utils.dirToSumY(i))) {
                min = best[i];
                dir = i;
            }
        moveTo(getX()+Utils.dirToSumX(dir),getY()+Utils.dirToSumY(dir));
    }

    public void moveTo(int x, int y) {
        if(Map.canMove(x,y)) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isBot() {
        return bot;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getID() {
        return ID;
    }

    public void updateArea() {
        area.updatePos();
    }

    public String getHP() {
        return ID + ": " + cHP + "(" + HP + ")";
    }

    public boolean isDead() {
        return cHP == 0;
    }

    public void hit(int damage) {
        cHP = Math.max(0, cHP-damage);
    }


}
