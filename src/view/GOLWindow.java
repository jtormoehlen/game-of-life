package view;

import core.GOL;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public class GOLWindow extends JPanel {

    GOL gol;

    public GOLWindow(GOL gol) {
        this.gol = gol;
        this.setSize(600, 600);
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < gol.getPop().length; i++) {
            for (int j = 0; j < gol.getPop().length; j++) {
                if (gol.getPop()[i][j]) {
                    g.setColor(Color.BLACK);
                    g.fillRect((i * gol.scale) + gol.offset, (j * gol.scale) + gol.offset, gol.scale, gol.scale);
                }

                g.setColor(Color.GRAY);
                g.drawRect((i * gol.scale) + gol.offset, (j * gol.scale) + gol.offset, gol.scale, gol.scale);
            }
        }
    }
}
