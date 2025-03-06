package controller;

import core.GOL;
import view.GOLDraw;
import view.GOLFile;

import javax.swing.*;

import java.awt.Color;
import java.util.HashMap;

/**
 * Created by jtormoehlen on 04.06.2021.
 */
public class GOLButton {

    private final HashMap<String, Object> golContainer;

    public GOLButton(HashMap<String, Object> golContainer) {
        this.golContainer = golContainer;

        timeControlButton();
        resetButton();
        randomStartButton();
        fileButton();
        importFileButton();
    }

    private void timeControlButton() {
        JButton timeControlButton = new JButton("Start");
        ((GOLPanel) golContainer.get("golPanel")).add(timeControlButton);
        Color defaultColor = timeControlButton.getBackground();

        timeControlButton.addActionListener(_ -> {
            ((GOLTimer) golContainer.get("golTimer")).toggleRunning();

            if (timeControlButton.getText() == "Start") {
                timeControlButton.setText("Stop");
                timeControlButton.setBackground(Color.RED);
            } else {
                timeControlButton.setText("Start");
                timeControlButton.setBackground(defaultColor);
            }
        });
    }

    private void resetButton() {
        JButton resetButton = new JButton("Reset");
        ((GOLPanel) golContainer.get("golPanel")).add(resetButton);

        resetButton.addActionListener(
                _ -> ((GOL) golContainer.get("gol")).initPop(((GOL) golContainer.get("gol")).getSize()));
    }

    private void randomStartButton() {
        JButton randomStartButton = new JButton("Random");
        ((GOLPanel) golContainer.get("golPanel")).add(randomStartButton);

        randomStartButton.addActionListener(_ -> ((GOL) golContainer.get("gol")).randomStart());
    }

    private void fileButton() {
        JButton fileButton = new JButton("from file");
        // ((GOLPanel) golContainer.get("golPanel")).add(fileButton);

        fileButton.addActionListener(
                _ -> new GOLFile((GOLDraw) golContainer.get("golDraw")).modelToFile("gol"));
    }

    private void importFileButton() {
        JButton importFileButton = new JButton("Import file");
        ((GOLPanel) golContainer.get("golPanel")).add(importFileButton);

        importFileButton.addActionListener(
                _ -> new GOLFile((GOLDraw) golContainer.get("golDraw")).fileToModel("config"));
    }
}
