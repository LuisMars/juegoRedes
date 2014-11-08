package es.upv.luimafus;


public class Area {
    private int px;
    private int py;
    private int time;
    private int radius = 3;
    private char father;

    public Area () {
        time = -1;
    }

    public Area (int x, int y, char ID) {
        px = x;
        py = y;
        time = radius;
        father = ID;
    }

    public void updatePos() {
        if(--time >= 0) {
            for (int i = 0; i < Map.getHeight(); i++) {
                for (int j = 0; j < Map.getWidth(); j++) {
                    if (distance(j, i, px, py) == radius - time)
                        Map.addAttack(new Attack(j, i, father));
                }
            }
        }
    }

    public int distance(int x, int y, int px, int py) {
        return (int)Math.round(Math.sqrt((x-px)*(x-px)+(y-py)*(y-py)));
    }
}
