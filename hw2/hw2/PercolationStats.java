package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private PercolationFactory percf;
    private int width;
    private int tests;
    private double[] stats;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        width = N;
        tests = T;
        stats = new double[T];
        percf = pf;
        for (int counter = 0; counter < T; counter++) {
            stats[counter] = simulation();
        }
    }

    private double simulation() {
        Percolation perc = percf.make(width);
        while (!perc.percolates()) {
            int row = StdRandom.uniform(width);
            int col = StdRandom.uniform(width);
            if (!perc.isOpen(row, col)) {
                perc.open(row, col);
            }
        }
        return (double) perc.numberOfOpenSites() / (width * width);
    }

    public double mean() {
        return StdStats.mean(stats);
    }

    public double stddev() {
        return StdStats.stddev(stats);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(tests);
    }
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(tests);
    }

}
