package week1;

import edu.princeton.cs.algs4.Percolation;
import edu.princeton.cs.algs4.PercolationVisualizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Run Percolation from files.
 * Tool to test Regex: https://regex101.com/
 *
 * @author juancho
 */
public class MainClass {

    private static final String JERRY = "./resources/jerry47.txt";
    private static final String HEART = "./resources/heart25.txt";
    private static final String GREETING = "./resources/greeting57.txt";

    private static Pattern pattern = Pattern.compile("[ ]*(\\d+)+[ ]*(\\d+)+");

    public static void main(String[] args) {
        int size;
        Percolation percolation;
        try (BufferedReader br = new BufferedReader(new FileReader(JERRY))) {
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
                PercolationVisualizer.draw(percolation, size);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
