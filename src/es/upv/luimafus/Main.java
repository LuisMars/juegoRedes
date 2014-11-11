package es.upv.luimafus;
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Console c = new Console();

        int h = 30;
        int w = 40;

        Map map = new Map(w, h, 0.70);
        c.add("Generating map...");
        c.putSize(w, h);
        map.addPlayer(new Player(false));

        for (int i = 0; i < 4; i++)
            map.addPlayer(new Player(true));

        while (true) {
            c.show(map.toString());
            Thread.sleep(170);
        }

    }


}
