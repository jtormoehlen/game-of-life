package core.random;

import java.util.Random;

public class SimplexNoise {
    private static final int grad3[][] = {
            { 1, 1, 0 }, { -1, 1, 0 }, { 1, -1, 0 }, { -1, -1, 0 },
            { 1, 0, 1 }, { -1, 0, 1 }, { 1, 0, -1 }, { -1, 0, -1 },
            { 0, 1, 1 }, { 0, -1, 1 }, { 0, 1, -1 }, { 0, -1, -1 }
    };

    private static final int p[] = new int[512];
    private static final int perm[] = new int[512];

    // Initialize permutations
    public SimplexNoise() {
        for (int i = 0; i < 256; i++) {
            p[i] = i;
        }
        // Shuffle permutation
        Random random = new Random();
        for (int i = 255; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swap(p, i, j);
        }
        for (int i = 0; i < 512; i++) {
            perm[i] = p[i & 255];
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static double noise(double xin, double yin) {
        // 2D-input factor and indentation
        double F2 = 0.5 * (Math.sqrt(3.0) - 1.0);
        double s = (xin + yin) * 0.5 * (Math.sqrt(3.0) - 1.0);
        int i = fastFloor(xin + s);
        int j = fastFloor(yin + s);
        double t = (i + j) * F2;
        // Unshifted point
        double X0 = i - t;
        double Y0 = j - t;
        // Unshifted position
        double x0 = xin - X0;
        double y0 = yin - Y0;

        // Indices for lattice cells
        int i1, j1;
        // Point in first part or elsewhere
        if (x0 > y0) {
            i1 = 1;
            j1 = 0;
        } else {
            i1 = 0;
            j1 = 1;
        }

        // Lattice vertices
        double x1 = x0 - i1 + F2;
        double y1 = y0 - j1 + F2;
        double x2 = x0 - 1.0 + 2.0 * F2;
        double y2 = y0 - 1.0 + 2.0 * F2;

        // Hash
        int ii = i & 255;
        int jj = j & 255;
        int gi0 = perm[ii + perm[jj]] % 12;
        int gi1 = perm[ii + i1 + perm[jj + j1]] % 12;
        int gi2 = perm[ii + 1 + perm[jj + 1]] % 12;

        // Vertex calculations
        double n0, n1, n2;
        double t0 = 0.5 - x0 * x0 - y0 * y0;
        if (t0 < 0)
            n0 = 0.0;
        else {
            t0 *= t0;
            // First vertex
            n0 = t0 * t0 * dot(grad3[gi0], x0, y0);
        }
        double t1 = 0.5 - x1 * x1 - y1 * y1;
        if (t1 < 0)
            n1 = 0.0;
        else {
            t1 *= t1;
            // Second vertex
            n1 = t1 * t1 * dot(grad3[gi1], x1, y1);
        }
        double t2 = 0.5 - x2 * x2 - y2 * y2;
        if (t2 < 0)
            n2 = 0.0;
        else {
            t2 *= t2;
            // Third vertex
            n2 = t2 * t2 * dot(grad3[gi2], x2, y2);
        }
        // Final noise scaled
        return 70.0 * (n0 + n1 + n2);
    }

    // Dot product helper function
    private static double dot(int[] g, double x, double y) {
        return g[0] * x + g[1] * y;
    }

    // Fast floor helper function
    private static int fastFloor(double x) {
        return x > 0 ? (int) x : (int) x - 1;
    }

    public double[][] generateNoise(int width, int height, double frequency) {
        double[][] noiseArray = new double[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                noiseArray[x][y] = noise(x * frequency, y * frequency);
            }
        }
        return noiseArray;
    }
}