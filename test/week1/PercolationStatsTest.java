package week1;

import week1.assigment.PercolationStats;
import org.junit.Test;

/**
 * @author juancho
 */
public class PercolationStatsTest {

    @Test
    public void successTest() {
        for (int i = 0; i < 10; i++) {
            PercolationStats percolationStats = new PercolationStats(200, 100);
            double mean = percolationStats.mean();
            double stddev = percolationStats.stddev();
            double confidenceLo = percolationStats.confidenceLo();
            double confidenceHi = percolationStats.confidenceHi();
            System.out.println("mean - " + mean);
        }
    }

    @Test
    public void mainTest() {
        String[] args = new String[2];
        args[0] = "200";
        args[1] = "100";
        PercolationStats.main(args);
    }
}
