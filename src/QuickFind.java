/**
 * @author juancho
 */
public class QuickFind implements Quick {

    private final int[] place;

    public QuickFind(int size) {

        place = new int[size];
        for (int i = 0; i < size; i++) {
            place[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return place[p] == place[q];
    }

    @Override
    public void union(int p, int q) {
        int pVal = place[p];
        int qVal = place[q];

        for (int i = 0; i < place.length; i++) {
            if (place[i] == pVal) place[i] = qVal;
        }
    }
}
