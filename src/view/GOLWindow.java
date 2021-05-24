package view;

import core.GOL;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public class GOLWindow extends JPanel {

    GOL gol;
    int offset;
    int scale;

    public GOLWindow(GOL gol) {
        setSize(600, 480);

        offset = gol.OFFSET;
        scale = gol.SCALE;
        this.gol = gol;
    }

    @Override
    public void paint(Graphics g) {

        for (int i = 0; i < gol.getPop().length; i++) {
            for (int j = 0; j < gol.getPop().length; j++) {

                if (gol.getPop()[i][j]) {
                    paintCell(g, i, j);
                }

                g.drawRect((i * scale) + offset, (j * scale) + offset, scale, scale);
            }
        }
    }

    private void paintCell(Graphics g, int x, int y) {
        g.fillRect((x * scale) + offset, (y * scale) + offset, scale, scale);
    }
}
