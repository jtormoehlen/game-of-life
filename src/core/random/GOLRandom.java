package core.random;

import java.util.Random;

import core.GOL;

/**
 * Created by jtormoehlen on 26.02.2025
 */
public class GOLRandom {

    private final int SEED = new Random().nextInt(Integer.MAX_VALUE);

    private GOL gol;

    public GOLRandom(GOL gol) {
        this.gol = gol;
    }

    public void neumann() {
        // Average density of living cells
        double density = 0.1;

        NeumannNeighborhood neumannNeighborhood = new NeumannNeighborhood(gol.getPop(), density);
        gol.setPop(neumannNeighborhood.singleRandomPop(), 0, 0);
        gol.setPop(neumannNeighborhood.fillWithClusters(), 0, 0);
    }

    public void simplexNoise() {
        // Noise frequency
        double frequency = 0.02;
        // Hieght mapping threshold
        double threshold = 0.5;

        SimplexNoise simplexNoise = new SimplexNoise();
        double[][] noise = simplexNoise.generateNoise(gol.getSize(), gol.getSize(), frequency);

        for (int x = 0; x < gol.getSize(); x++) {
            for (int y = 0; y < gol.getSize(); y++) {
                gol.getPop()[x][y] = noise[x][y] > threshold;
            }
        }
    }

    public void clustering() {
        Random random = new Random();
        double paramA = .01d;
        double paramAA = .50d;
        double probability;

        for (int i = 0; i < gol.getPop().length; i++) {
            for (int j = 0; j < gol.getPop().length; j++) {
                probability = random.nextDouble();

                try {
                    if (!gol.getPop()[i - 1][j] && !gol.getPop()[i][j - 1]) {
                        if (probability <= paramA) {
                            gol.getPop()[i][j] = true;
                        }
                    } else {
                        if (probability <= paramAA) {
                            gol.getPop()[i][j] = true;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) { 
                    /* do nothing */
                }
            }
        }

        for (int i = 0; i < gol.getPop().length; i++) {
            for (int j = 0; j < gol.getPop().length; j++) {
                if (gol.getNeighborCount(i, j) <= 2) {
                    gol.getPop()[i][j] = false;
                }
            }
        }
    }
}