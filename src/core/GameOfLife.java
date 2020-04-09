package core;

/**
 * Created by jtormoehlen on 16.03.2020.
 */
public interface GameOfLife {

    void initPop(int size);

    int getNeighborCount(int x, int y);

    void select();

    boolean isExtinct();
}
