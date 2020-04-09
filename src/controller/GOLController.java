package controller;

import core.GOL;
import view.GOLWindow;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLController {

    GOL gol;
    GOLWindow golWindow;
    GOLListener golListener;

    public GOLController() {
        gol = new GOL();
        golWindow = new GOLWindow(gol);
        golWindow.setVisible(true);
        golListener = new GOLListener();
        golWindow.addMouseListener(golListener);
    }

    public void simulate() throws InterruptedException {

        int size = 100;
        gol.initPop(size);

        /* oscillating */
//        gol.actCell(1, 0);
//        gol.actCell(1, 1);
//        gol.actCell(1, 2);

        /* r-pentomino */
        gol.actCell(0, 1);
        gol.actCell(0, 2);
        gol.actCell(1, 0);
        gol.actCell(1, 1);
        gol.actCell(2, 1);

        /* finite pattern */
//        gol.actCell(0, 0);
//        gol.actCell(0, 1);
//        gol.actCell(0, 2);
//        gol.actCell(1, 0);
//        gol.actCell(1, 2);
//        gol.actCell(2, 0);
//        gol.actCell(2, 2);
//        gol.actCell(4, 0);
//        gol.actCell(4, 2);
//        gol.actCell(5, 0);
//        gol.actCell(5, 2);
//        gol.actCell(6, 0);
//        gol.actCell(6, 1);
//        gol.actCell(6, 2);

        /* star ship */
//        gol.actCell(0, 1);
//        gol.actCell(1, 2);
//        gol.actCell(2, 2);
//        gol.actCell(2, 1);
//        gol.actCell(2, 0);

        while (!gol.isExtinct()) {
            golWindow.repaint();

            if (gol.isEdged()) {
                gol.extendField();
            }

            gol.select();

            Thread.sleep(300);
        }

        golWindow.repaint();
    }
}
