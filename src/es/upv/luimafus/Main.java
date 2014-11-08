package es.upv.luimafus;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main {

    private static int w = 60;
    private static int h = 40;

    public static void main(String[] args) throws InterruptedException {

        Console c = new Console();




        Map map = new Map(w, h, 0.70);
        c.putSize(w,h);
        map.addPlayer(new Player(map));
        while (true) {
            c.show(map.toString());
            Thread.sleep(75);
        }

    }


}
