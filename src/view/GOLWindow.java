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
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < golDraw.getGOL().getPop().length; i++) {
            for (int j = 0; j < golDraw.getGOL().getPop().length; j++) {
                if (golDraw.getGOL().getPop()[i][j]) {
                    g.setColor(Color.BLACK);
                    g.fillRect(
                            (i * golDraw.getScale()) + golDraw.getOffset(),
                            (j * golDraw.getScale()) + golDraw.getOffset(),
                            golDraw.getScale(), golDraw.getScale()
                    );
                }

                g.setColor(Color.GRAY);
                g.drawRect(
                        (i * golDraw.getScale()) + golDraw.getOffset(),
                        (j * golDraw.getScale()) + golDraw.getOffset(),
                        golDraw.getScale(), golDraw.getScale()
                );
            }
        }
    }
}
