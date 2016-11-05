package week1.assigment;

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author juan.saravia
 */
public class PercolationStats {

    private final double[] thresholds;
    private final int trials;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.trials = trials;
        this.thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            thresholds[i] = discoverThreshold(n);
        }
    }

    // test client (described below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96D / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96D / Math.sqrt(trials));
    }

    private double discoverThreshold(int n) {
        int stepsCounter = 0;
        Percolation percolation = new Percolation(n);
        do {
            stepsCounter++;
            boolean pointFound = false;
            int row = 0;
            int col = 0;
            while (!pointFound) {
                row = StdRandom.uniform(1, n + 1);
                col = StdRandom.uniform(1, n + 1);
                pointFound = !percolation.isOpen(row, col);
            }
            percolation.open(row, col);
        } while (!percolation.percolates());

        return (double) stepsCounter / ((double) n * (double) n);
    }
}
