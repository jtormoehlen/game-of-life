package controller;

import app.GOLApp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by jtormoehlen on 09.06.2021.
 */
public class GOLPanel extends JPanel {

    HashMap<String, Object> golContainer;

    public GOLPanel(HashMap<String, Object> golContainer) {
        this.golContainer = golContainer;

        setVisible(true);
        ((GOLApp)golContainer.get("golApp")).add(this, BorderLayout.SOUTH);
    }
}
