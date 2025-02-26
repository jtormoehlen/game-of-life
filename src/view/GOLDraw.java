package view;

import core.GOL;

/**
 * Created by jtormoehlen on 05.06.2021.
 */
public class GOLDraw {

    private GOL gol;

    private int offset = 20;
    private int scale = 10;

    public GOLDraw(GOL gol) {
        this.gol = gol;
    }

    public int worldToModel(int worldValue) {
        return (worldValue - offset) / scale;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        if (scale <= 100 && scale >= 10) {
            this.scale = scale;
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public GOL getGOL() {
        return gol;
    }

    public String modelToText() {
        String fieldString = "";

        for (int i = 0; i < gol.getPop().length; i++) {
            for (int j = 0; j < gol.getPop().length; j++) {
                fieldString += "+   ";
            }

            fieldString += "+\n";

            for (int j = 0; j < gol.getPop().length; j++) {
                // if (gol.getPop()[j][i]) {
                //     fieldString += "  # ";
                // } else {
                //     fieldString += "    ";
                // }
                fieldString += "  " + gol.getNeighborCount(j, i) + " ";
            }

            fieldString += "\n";
        }

        return fieldString;
    }

    public void textToModel(boolean[][] pop, int dx, int dy) {
        gol.setPop(pop, dx, dy);
    } 
}
