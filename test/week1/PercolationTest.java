package week1;

import org.junit.Assert;
import org.junit.Test;
import week1.assigment.Percolation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author juancho
 */
public class PercolationTest {

    private static final String FILE_PATH = "./resources/";
    private static final Pattern pattern = Pattern.compile("[ ]*(\\d+)+[ ]*(\\d+)+");

    @Test
    public void input1SuccessPercolationTest() {
        Percolation percolation = new Percolation(1);
        percolation.open(1, 1);

        Assert.assertTrue(percolation.percolates());
        Assert.assertTrue(percolation.isOpen(1, 1));
    }

    @Test
    public void input2NoPercolationTest() {
        Percolation percolation = new Percolation(2);
        percolation.open(1, 1);
        percolation.open(2, 2);

        Assert.assertFalse(percolation.percolates());
        Assert.assertTrue(percolation.isOpen(1, 1));
        Assert.assertTrue(percolation.isOpen(2, 2));
    }

    @Test
    public void input20Test() throws IOException {
        Percolation percolation = loadPercolationFromFile("input20.txt");

        Assert.assertTrue(percolation.percolates());
        //Assert.assertFalse(percolation.isFull(18, 1)); FIXME
        Assert.assertTrue(percolation.isOpen(18, 1));
    }

    @Test
    public void input3Test() throws IOException {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 1);
        Assert.assertTrue(percolation.isFull(3, 1));
        percolation.open(2, 1);
        percolation.open(1, 1);

        Assert.assertTrue(percolation.percolates());
    }

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

    private Percolation loadPercolationFromFile(String fileName) throws IOException {
        int size;
        Percolation percolation = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + fileName))) {
            String line;
            if ((line = br.readLine()) != null) {
                size = Integer.parseInt(line);
                percolation = new Percolation(size);
                while ((line = br.readLine()) != null) {
                    // process the line.
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches() && matcher.groupCount() > 1) {
                        percolation.open(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                    }
                }
            }
        }
        return percolation;
    }
}
