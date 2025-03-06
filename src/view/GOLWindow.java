package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public class GOLWindow extends JPanel {

    private GOLDraw golDraw;

    public GOLWindow(GOLDraw golDraw) {
        this.golDraw = golDraw;

        setSize(600, 600);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        boolean[][] population = golDraw.getGOL().getPop();
        int scale = golDraw.getScale();
        int offset = golDraw.getOffset();
        int rows = population.length;
        int cols = population[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = (i * scale) + offset;
                int y = (j * scale) + offset;

                // Set color for living cell
                if (population[i][j]) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, scale, scale);
                }

                // Set color for grid lines
                g.setColor(Color.GRAY);
                g.drawRect(x, y, scale, scale);
            }
        }
    }
}
