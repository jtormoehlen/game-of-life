package core.random;

import java.util.Random;

public class NeumannNeighborhood {
    private static final Random random = new Random();

    private boolean[][] pop;
    private double density;

    public NeumannNeighborhood(boolean[][] pop, double density) {
        this.pop = pop;
        this.density = density;
    }

    public boolean[][] singleRandomPop() {
        int n = pop.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Toggle cell based on density parameter
                pop[i][j] = random.nextDouble() < density;
            }
        }

        return pop;
    }

    public boolean[][] fillWithClusters() {
        int n = pop.length;

        // For all cells toggle neumann neighbors
        boolean[][] neumannPop = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pop[i][j]) {
                    neumannPop = neumannNeighbors(neumannPop, i, j);
                }
            }
        }
        // Join random population and neumann neighbors
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pop[i][j] || neumannPop[i][j]) {
                    pop[i][j] = true;
                } 
            }
        }

        return pop;
    }

    private boolean[][] neumannNeighbors(boolean[][] pop, int i, int j) {
        /**
         * Neumann neigbors of centered cell (living x; dead o):
         * o x o
         * x x x
         * o x o
         */
        try {
            if (i > 0 && i < pop.length - 1) {
                if (j > 0 && j < pop.length - 1) {
                    pop[i - 1][j] = true;
                    pop[i + 1][j] = true;
                    pop[i][j - 1] = true;
                    pop[i][j + 1] = true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array bounds reached!");
        }

        return pop;
    }
}