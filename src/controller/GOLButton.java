package controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jtormoehlen on 04.06.2021.
 */
public class GOLButton {

    GOLController golController;

    boolean isRunning;

    public GOLButton(GOLController golController) {
        this.golController = golController;
        this.timeControlButton();
        this.resetButton();
        this.randomStartButton();
    }

    public void timeControlButton() {
        JButton timeControlButton = new JButton("Start");
        golController.controlPanel.add(timeControlButton);
        golController.controlPanel.setVisible(true);
        golController.golApp.add(golController.controlPanel, BorderLayout.SOUTH);

        timeControlButton.addActionListener(actionEvent -> {
            isRunning = !isRunning;

            if (timeControlButton.getText() == "Start") {
                timeControlButton.setText("Stopp");
            } else {
                timeControlButton.setText("Start");
            }
        });
    }

    public void resetButton() {
        JButton resetButton = new JButton("Reset");
        golController.controlPanel.add(resetButton);
        golController.controlPanel.setVisible(true);
        golController.golApp.add(golController.controlPanel, BorderLayout.SOUTH);

        resetButton.addActionListener(actionEvent -> golController.gol.initPop(golController.gol.getSize()));
    }

    public void randomStartButton() {
        JButton randomStartButton = new JButton("Random");
        golController.controlPanel.add(randomStartButton);
        golController.controlPanel.setVisible(true);
        golController.golApp.add(golController.controlPanel, BorderLayout.SOUTH);

        randomStartButton.addActionListener(actionEvent -> golController.gol.randomStart());
    }
}
