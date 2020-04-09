package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x: " + e.getX() + " | y: " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
