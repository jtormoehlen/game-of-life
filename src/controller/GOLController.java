package controller;

import app.GOLApp;
import core.GOL;
import view.GOLWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLController {

    GOL gol;
    GOLWindow golWindow;
    GOLListener golListener;
    GOLApp golApp;

    boolean isRunning;

    public GOLController(GOLApp golApp) {
        this.golApp = golApp;
        gol = new GOL();
        golWindow = new GOLWindow(gol);
        golWindow.setVisible(true);
        golListener = new GOLListener(gol);
        golWindow.addMouseListener(golListener);
        this.golApp.add(golWindow);

        isRunning = false;
        timeControlButton();
    }

    public void timeControlButton() {
        JPanel timeControlPanel = new JPanel();
        JButton timeControlButton = new JButton("Start");
        timeControlPanel.add(timeControlButton);
        timeControlPanel.setVisible(true);
        golApp.add(timeControlPanel, BorderLayout.SOUTH);

        timeControlButton.addActionListener(ae -> {
            isRunning = !isRunning;

            if (timeControlButton.getText() == "Start") {
                timeControlButton.setText("Stopp");
            } else {
                timeControlButton.setText("Start");
            }
        });
    }

    public void simulate() throws InterruptedException {

        int size = 50;
        gol.initPop(size);

        /* oscillating */
//        gol.actCell(1, 0);
//        gol.actCell(1, 1);
//        gol.actCell(1, 2);

        /* r-pentomino */
//        gol.actCell(10, 11);
//        gol.actCell(10, 12);
//        gol.actCell(11, 10);
//        gol.actCell(11, 11);
//        gol.actCell(12, 11);

        /* finite pattern */
//        gol.toggleCell(10, 10);
//        gol.toggleCell(10, 11);
//        gol.toggleCell(10, 12);
//        gol.toggleCell(11, 10);
//        gol.toggleCell(11, 12);
//        gol.toggleCell(12, 10);
//        gol.toggleCell(12, 12);
//        gol.toggleCell(14, 10);
//        gol.toggleCell(14, 12);
//        gol.toggleCell(15, 10);
//        gol.toggleCell(15, 12);
//        gol.toggleCell(16, 10);
//        gol.toggleCell(16, 11);
//        gol.toggleCell(16, 12);

        /* star ship */
//        gol.actCell(0, 1);
//        gol.actCell(1, 2);
//        gol.actCell(2, 2);
//        gol.actCell(2, 1);
//        gol.actCell(2, 0);

        while (true) {
            golApp.repaint();
            gol.select();

            if (isRunning) {
                Thread.sleep(100);
            } else {
                while (!isRunning) {
                    golApp.repaint();
                    Thread.sleep(100);
                }
            }
        }
    }
}
