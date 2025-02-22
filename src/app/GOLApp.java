package app;

import controller.GOLController;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLApp extends JFrame {

    public GOLApp() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        GOLApp golApp = new GOLApp();
        GOLController golController = new GOLController(golApp);

        golApp.setTitle("GameOfLife");
        golApp.setSize(850, 950);
        golApp.setVisible(true);
        golApp.setResizable(false);

        try {
            new GOLRunner(golController.getGolContainer()).run();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
