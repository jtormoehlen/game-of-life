package controller;

import core.GOL;

import java.awt.event.*;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLListener implements MouseListener, MouseMotionListener, MouseWheelListener {

    GOL gol;

    public GOLListener(GOL gol) {
        this.gol = gol;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            gol.toggleCell(gol.worldValueToModelValue(e.getX()), gol.worldValueToModelValue(e.getY()));
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            /* ignore */
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) {
        try {
            gol.actCell(gol.worldValueToModelValue(e.getX()), gol.worldValueToModelValue(e.getY()));
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            /* ignore */
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) { }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            gol.setScale(gol.getScale() * 2);
            gol.setSize(gol.getSize() / 2);
        } else if (e.getWheelRotation() > 0) {
            gol.setScale(gol.getScale() / 2);
            gol.setSize(gol.getSize() * 2);
        }
    }
}
