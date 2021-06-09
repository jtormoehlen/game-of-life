package controller;

import app.GOLApp;
import core.GOL;
import view.GOLDraw;
import view.GOLFile;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by jtormoehlen on 04.06.2021.
 */
public class GOLButton {

    private HashMap<String, Object> golContainer;

    public GOLButton(HashMap<String, Object> golContainer) {
        this.golContainer = golContainer;

        timeControlButton();
        resetButton();
        randomStartButton();
        fileButton();
    }

    private void timeControlButton() {
        JButton timeControlButton = new JButton("Start");
        ((GOLPanel)golContainer.get("golPanel")).add(timeControlButton);

        timeControlButton.addActionListener(actionEvent -> {
            ((GOLTimer)golContainer.get("golTimer")).toggleRunning();

            if (timeControlButton.getText() == "Start") {
                timeControlButton.setText("Stopp");
            } else {
                timeControlButton.setText("Start");
            }
        });
    }

    private void resetButton() {
        JButton resetButton = new JButton("Reset");
        ((GOLPanel)golContainer.get("golPanel")).add(resetButton);

        resetButton.addActionListener(actionEvent ->
                ((GOL)golContainer.get("gol")).initPop(((GOL)golContainer.get("gol")).getSize())
        );
    }

    private void randomStartButton() {
        JButton randomStartButton = new JButton("Random");
        ((GOLPanel)golContainer.get("golPanel")).add(randomStartButton);

        randomStartButton.addActionListener(actionEvent ->
                ((GOL)golContainer.get("gol")).randomStart()
        );
    }

    private void fileButton() {
        JButton fileButton = new JButton("File");
        ((GOLPanel)golContainer.get("golPanel")).add(fileButton);

        fileButton.addActionListener(actionEvent ->
                new GOLFile((GOLDraw) golContainer.get("golDraw")).modelToFile("gol")
        );
    }
}
