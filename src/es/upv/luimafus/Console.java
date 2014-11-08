package es.upv.luimafus;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Console extends JFrame implements KeyListener {
    private JTextPane show;
    private JPanel Panel;

    public Console() {
        setVisible(true);
        setContentPane(Panel);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        show.addKeyListener(this);
        show.grabFocus();

    }

    public void putSize(int x, int y) {
        setSize(x*22,y*20);
        Panel.setSize(x*22, y*20);
        show.setSize(x*22, y*20);

        setLocationRelativeTo(null);
    }

    public void show(String s) {
        show.setText(s);
    }

    public void add(String s) {
        show.setText(show.getText() + s);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'q')
            System.exit(0);
        Map.act(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
