package es.upv.luimafus;

public class Player {


    private int x;
    private int y;

    private int lastAtt = 0;

    private int HP = 10;
    private int cHP = HP;

    private Area area = new Area();


    private char ID;

    private static int n_players = 0;

    public Player() {
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
        Map.movePlayer(this, pX, pY);
    }

    public void attack(int direction) {
        int reloadTime = 2;
        if((int)(System.currentTimeMillis()/100) - lastAtt > reloadTime) {

            lastAtt = (int)(System.currentTimeMillis()/100);
            if(direction == -1)
                area = new Area(x, y, ID);
            else
                Map.addAttack(new Attack(x, y, direction, ID));
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

    public char getID() {
        return ID;
    }

    public void updateArea() {
        area.updatePos();
    }

    public String getHP() {
        return ID + ": " + cHP + "(" + HP + ")";
    }

    public void hit(int damage) {
        cHP = Math.max(0, cHP-damage);
    }
}
