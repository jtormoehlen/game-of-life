package controller;

import view.GOLDraw;

import java.awt.event.*;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLListener implements MouseListener, MouseMotionListener, MouseWheelListener {

    private GOLDraw golDraw;

    public GOLListener(GOLDraw golDraw) {
        this.golDraw = golDraw;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            golDraw.getGOL().toggleCell(
                    golDraw.worldToModel(e.getX()), golDraw.worldToModel(e.getY())
            );
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
            golDraw.getGOL().toggleCell(
                    golDraw.worldToModel(e.getX()), golDraw.worldToModel(e.getY()), true
            );
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            /* ignore */
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) { }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            golDraw.setScale(golDraw.getScale() * 2);
            golDraw.getGOL().setSize(golDraw.getGOL().getSize() / 2);
        } else if (e.getWheelRotation() > 0) {
            golDraw.setScale(golDraw.getScale() / 2);
            golDraw.getGOL().setSize(golDraw.getGOL().getSize() * 2);
        }
    }
}
