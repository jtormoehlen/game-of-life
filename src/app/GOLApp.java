package app;

import controller.GOLController;

import javax.swing.*;
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
        golApp.setTitle("GameOfLife");
        golApp.setSize(800, 800);
        GOLController golController = new GOLController(golApp);
        golApp.setVisible(true);

        try {
            golController.simulate();
        } catch (InterruptedException e) { }
    }
}
