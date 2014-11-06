package es.upv.luimafus;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Console c = new Console();



        Map map = new Map(30, 20, 0.20);
        map.addPlayer(new Player(map));
        while (true) {
            c.show(map.toString());
            Thread.sleep(75);
        }

    }


}
