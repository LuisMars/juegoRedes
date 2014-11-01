package es.upv.luimafus;

import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Map map = new Map(30, 20, 0.10);
        map.addPlayer(new Player(map));
        map.addPlayer(new Player(map));

        for (int i = 0; i < 10; i++) {
            System.out.println(map);
            for (Player p : map.getPlayers()) {
                System.out.print("Where to move player " + p.getID() + "? ");
                p.move(scn.nextLine().charAt(0));
            }
        }
    }


}
