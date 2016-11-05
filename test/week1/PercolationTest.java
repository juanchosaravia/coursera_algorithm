package week1;

import org.junit.Assert;
import org.junit.Test;
import edu.princeton.cs.algs4.Percolation;

/**
 * @author juancho
 */
public class PercolationTest {

    @Test
    public void simpleSuccessPercolationTest() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(3, 1);

        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void simpleSuccessPercolationTest2() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 3);
        percolation.open(3, 2);

        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void simpleSuccessPercolationTest3() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(2, 2);
        percolation.open(3, 1);
        percolation.open(3, 2);
        percolation.open(3, 3);

        Assert.assertTrue(percolation.percolates());
    }

    @Test
    public void simpleNoPercolationTest() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(2, 1);
        percolation.open(2, 3);
        percolation.open(3, 3);

        Assert.assertFalse(percolation.percolates());
    }

    @Test
    public void simpleNoPercolationTest2() {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 3);

        Assert.assertFalse(percolation.percolates());
    }
}
