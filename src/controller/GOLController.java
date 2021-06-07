package controller;

import app.GOLApp;
import core.GOL;
import view.GOLWindow;

import javax.swing.*;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLController {

    GOL gol;
    GOLApp golApp;
    GOLTimer golTimer;
    GOLWindow golWindow;
    GOLButton golButton;
    GOLSlider golSlider;
    GOLListener golListener;
    JPanel controlPanel;

    public GOLController(GOLApp golApp) {
        this.golApp = golApp;
        this.initController();
    }

    public void initController() {
        gol = new GOL();
        golTimer = new GOLTimer();
        controlPanel = new JPanel();
        golWindow = new GOLWindow(gol);
        golListener = new GOLListener(gol);
        golButton = new GOLButton(this);
        golSlider = new GOLSlider(this);
        golWindow.setVisible(true);
        golWindow.addMouseListener(golListener);
        golWindow.addMouseMotionListener(golListener);
        golWindow.addMouseWheelListener(golListener);
        golApp.add(golWindow);
    }

    public void simulate() throws InterruptedException {
        gol.initPop(80);
        golTimer.start();

        while (true) {
            if (golButton.isRunning) {
                gol.select();
                golTimer.delayTime();
            }
            golApp.repaint();
        }
    }
}
