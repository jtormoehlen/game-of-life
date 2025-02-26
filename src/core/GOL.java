package core;

import java.util.Random;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public class GOL implements GameOfLife {

    private boolean[][] pop;

    public GOL(int size) {
        initPop(size);
    }

    public void initPop(int size) {
        pop = new boolean[size][size];
    }

    public void toggleCell(int x, int y) {
        pop[x][y] = !pop[x][y];
    }

    public void toggleCell(int x, int y, boolean value) {
        pop[x][y] = value;
    }

    public int getNeighborCount(int x, int y) {
        int count = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                int k = i;
                int l = j;

                if (k == -1) {
                    k = pop.length - 1;
                }

                if (k == pop.length) {
                    k = 0;
                }

                if (l == -1) {
                    l = pop.length - 1;
                }

                if (l == pop.length) {
                    l = 0;
                }

                if (!(k == x && l == y)) {
                    if (pop[k][l]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public void select() {
        boolean nextPop[][] = new boolean[pop.length][pop.length];

        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {
                int currNeighborCount = getNeighborCount(i, j);

                if (!pop[i][j] && currNeighborCount == 3) {
                    nextPop[i][j] = true;
                }

                if (pop[i][j] && currNeighborCount < 2) {
                    nextPop[i][j] = false;
                } else if (pop[i][j] && currNeighborCount <= 3) {
                    nextPop[i][j] = true;
                } else if (pop[i][j] && currNeighborCount > 3) {
                    nextPop[i][j] = false;
                }
            }
        }

        pop = nextPop;
    }

    public void randomStart() {
        initPop(this.getSize());

        Random random = new Random();
        double paramA = .01d;
        double paramAA = .50d;
        double probability;

        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {
                probability = random.nextDouble();

                try {
                    if (!pop[i - 1][j] && !pop[i][j - 1]) {
                        if (probability <= paramA) {
                            pop[i][j] = true;
                        }
                    } else {
                        if (probability <= paramAA) {
                            pop[i][j] = true;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) { }
            }
        }

        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {
                if (getNeighborCount(i, j) <= 2) {
                    pop[i][j] = false;
                }
            }
        }
    }

    public boolean isExtinct() {
        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {

                if (pop[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isEdged() {
        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {

                if (i == 0 || i == pop.length - 1 || j == 0 || j == pop.length - 1) {

                    if (pop[i][j]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void extendField() {
        boolean[][] tmpField = new boolean[pop.length + 2][pop.length + 2];

        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {

                tmpField[i + 1][j + 1] = pop[i][j];
            }
        }

        pop = tmpField;
    }

    public int getSize() {
        return pop.length;
    }

    public void setSize(int size) {
        if (size >= 8 && size <= 128) {
            boolean[][] temp = new boolean[size][size];

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    try {
                        temp[i][j] = pop[i][j];
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) { }
                }
            }

            pop = temp;
        }
    }

    public boolean[][] getPop() {
        return pop;
    }

    public void setPop(boolean[][] pop, int dx, int dy) {
        initPop(getPop().length);

        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {
                this.pop[i + dx][j + dy] = pop[i][j];
            }
        }
    }
}
