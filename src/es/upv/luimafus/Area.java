package es.upv.luimafus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 06/11/2014.
 */
public class Area {
    private int px;
    private int py;
    private int time;
    private int radius = 10;

    public Area () {
        time = -1;
    }

    public Area (int x, int y) {
        px = x;
        py = y;
        time = radius;
    }

    public void updatePos() {
        if(--time >= 0) {
            for (int i = 0; i < Map.getHeight(); i++) {
                for (int j = 0; j < Map.getWidth(); j++) {
                    if (distance(j, i, px, py) == radius - time)
                        Map.addAttack(new Attack(j, i));
                }
            }
        }
    }

    public int distance(int x, int y, int px, int py) {
        return (int)Math.round(Math.sqrt((x-px)*(x-px)+(y-py)*(y-py)));
    }
}
