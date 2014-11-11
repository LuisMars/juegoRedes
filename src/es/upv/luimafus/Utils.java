package es.upv.luimafus;

/**
 * Created by Luis on 10/11/2014.
 */
public class Utils {
    public static int distance(int x, int y, int px, int py) {
        return (int)Math.round(Math.sqrt((x-px)*(x-px)+(y-py)*(y-py)));
    }

    public static int distance(Player a, Player b) {
        return distance(a.getX(),a.getY(),b.getX(),b.getY());
    }

    public static int dirToSumX (int pos) {
        if(pos == 3)
            return -1;
        else if(pos == 1)
            return 1;
        else return 0;
    }

    public static int dirToSumY (int pos) {
        if(pos == 0)
            return -1;
        else if (pos == 2)
            return 1;
        else
            return 0;
    }
}
