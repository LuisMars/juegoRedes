package es.upv.luimafus;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main {


    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        Console c = new Console();



        Map map = new Map(30, 20, 0.10);
        map.addPlayer(new Player(map));
        map.addPlayer(new Player(map));

        while (true) {
            //System.out.println(map);
            c.show(map.toString());
            c.add("Where to move player " + map.cPlayer.getID() + "? ");
            Thread.sleep(500);
        }
    }


}
