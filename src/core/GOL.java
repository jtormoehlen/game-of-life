package core;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public class GOL implements GameOfLife {

    public final int OFFSET = 100;
    public final int SCALE = 10;

    private boolean[][] pop;

    public void initPop(int size) {
        pop = new boolean[size][size];
    }

    public void toggleCell(int x, int y) {
        pop[x][y] = !pop[x][y];
    }

    public int getNeighborCount(int x, int y) {
        int count = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i == x && j == y)) {

                    try {
                        if (pop[i][j]) {
                            count++;
                        }
                    } catch (IndexOutOfBoundsException e) { }
                }
            }
        }

        return count;
    }

    public void select() {
        boolean tempPop[][] = new boolean[pop.length][pop.length];

        for (int i = 0; i < pop.length; i++) {
            for (int j = 0; j < pop.length; j++) {
                int currNeighborCount = getNeighborCount(i, j);

                if (!pop[i][j] && currNeighborCount == 3) {
                    tempPop[i][j] = true;
                }

                if (pop[i][j] && currNeighborCount < 2) {
                    tempPop[i][j] = false;
                } else if (pop[i][j] && currNeighborCount <= 3) {
                    tempPop[i][j] = true;
                } else if (pop[i][j] && currNeighborCount > 3) {
                    tempPop[i][j] = false;
                }
            }
        }

        pop = tempPop;
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

    public int worldValueToArrayValue(int worldValue) {
        return (worldValue - OFFSET) / SCALE;
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

    public boolean[][] getPop() {
        return pop;
    }
}
