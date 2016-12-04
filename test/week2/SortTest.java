package week2;

import org.junit.Test;
import week2.sort.InsertionSort;
import week2.sort.SelectionSort;

import static org.junit.Assert.*;

/**
 * @author juancho
 */
public class SortTest {

    @Test
    public void insertionSortTest() throws Exception {
        Integer[] a = getValues();
        InsertionSort.sort(a);
        assertArray(a);
    }

    @Test
    public void selectionSortTest() throws Exception {
        Integer[] a = getValues();
        SelectionSort.sort(a);
        assertArray(a);
    }

    private Integer[] getValues() {
        Integer[] a = new Integer[5];
        a[0] = 2;
        a[1] = 1;
        a[2] = 0;
        a[3] = 3;
        a[4] = 4;
        return a;
    }

    private void assertArray(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            assertEquals(i, a[i].intValue());
        }
    }
}