package week2;

import org.junit.Test;
import week2.sort.SelectionSort;

import static org.junit.Assert.*;

/**
 * @author juancho
 */
public class SelectionSortTest {

    @Test
    public void sort() throws Exception {
        Integer[] a = new Integer[5];
        a[0] = 2;
        a[1] = 1;
        a[2] = 0;
        a[3] = 3;
        a[4] = 4;
        SelectionSort.sort(a);

        for (int i = 0; i < a.length; i++) {
            assertEquals(i, a[i].intValue());
        }
    }

}