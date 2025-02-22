package controller;

import app.GOLApp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by jtormoehlen on 09.06.2021.
 */
public class GOLPanel extends JPanel {

    public GOLPanel(HashMap<String, Object> golContainer) {
        setVisible(true);
        ((GOLApp)golContainer.get("golApp")).add(this, BorderLayout.SOUTH);
    }
}
