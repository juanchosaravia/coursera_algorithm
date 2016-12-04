package week2.sort;

/**
 * @author juancho
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {

            for (int j = i; j > 0; j--) {
                if (isLess(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
