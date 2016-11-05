package week1;

import week1.assigment.Percolation;

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

    private static final String FILE_PATH = "./resources/";

    private static final String JERRY = FILE_PATH + "jerry47.txt";
    private static final String HEART = FILE_PATH + "heart25.txt";
    private static final String GREETING = FILE_PATH + "greeting57.txt";
    private static final String INPUT_20 = FILE_PATH + "input20.txt";

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
