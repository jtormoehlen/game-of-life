package controller;

import core.GOL;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLListener implements MouseListener {

    GOL gol;

    public GOLListener(GOL gol) {
        this.gol = gol;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x: " + e.getX() + " | y: " + e.getY());

        int xWorld = gol.worldValueToArrayValue(e.getX());
        int yWorld = gol.worldValueToArrayValue(e.getY());

        gol.toggleCell(xWorld, yWorld);
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
