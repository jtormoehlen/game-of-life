package core;

/**
 * Created by jtormoehlen on 05.06.2021.
 */
public class GOLDraw extends GOL {

    private int offset = 20;
    private int scale = 10;

    private boolean pop[][];

    public GOLDraw(boolean[][] pop) {
        this.pop = pop;
    }

    public int worldToModel(int worldValue) {
        return (worldValue - offset) / scale;
    }

    public void printPop() {
        String fieldString = "";

        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {

                fieldString += "|";

                if (pop[i][j]) {
                    fieldString += "#";
                } else {
                    fieldString += " ";
                }
            }

            fieldString += "|\n";
        }

        System.out.println(fieldString);
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        if (scale <= 100 && scale >= 10) {
            this.scale = scale;
        }
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
