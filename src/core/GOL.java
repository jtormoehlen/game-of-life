package core;

import java.util.Random;

import core.random.GOLRandom;
import core.random.NeumannNeighborhood;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public class GOL implements GameOfLife {

    private boolean[][] pop;
    private byte randomMode;

    public GOL(int size) {
        initPop(size);
        randomMode = (byte) Byte.MIN_VALUE;
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
        int rows = pop.length;
        int cols = pop[0].length;
    
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    // Ignore edged cell
                    continue;
                }
    
                // Berechne die Nachbarn unter Berücksichtigung der Zyklen
                int k = (x + i + rows) % rows; // Wickel um die Zeilen
                int l = (y + j + cols) % cols; // Wickel um die Spalten
    
                if (pop[k][l]) {
                    count++;
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

        GOLRandom golRandom = new GOLRandom(this);

        switch (randomMode) {
            case 0:
                boolean[][] randomPop = new NeumannNeighborhood(pop, 0.1).singleRandomPop();
                setPop(randomPop, 0, 0);
                break;
            case 1:
                golRandom.clustering();
                break;
            case 2:
                golRandom.simplexNoise();
                break;
            case 3:
                golRandom.neumann();
                break;
            default:
                System.out.println("No option for randomizer chosen!");
                break;
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
        if (size >= 8 && size <= 64) {
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
                this.pop[i + dy][j + dx] = pop[i][j];
            }
        }
    }

    public void setRandomMode(byte randomMode) {
        this.randomMode = randomMode;
    }
}
