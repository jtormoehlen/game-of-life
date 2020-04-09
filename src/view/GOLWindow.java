package view;

import core.GOL;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public class GOLWindow extends Frame {

    private GOL gol;
    private int offset;
    private int scale;

    public GOLWindow(GOL gol) {
        setSize(1024, 768);

        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { System.exit( 0 ); }
        } );

        offset = 50;
        scale = 15;
        this.gol = gol;
    }

    @Override
    public void paint(Graphics g) {

        for (int i = 0; i < gol.getPop().length; i++) {
            for (int j = 0; j < gol.getPop().length; j++) {

                if (gol.getPop()[i][j]) {
                    g.fillRect((i * scale) + offset, (j * scale) + offset, scale, scale);
                }
            }
        }
    }
}
