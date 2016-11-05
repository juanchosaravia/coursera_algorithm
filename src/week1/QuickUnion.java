package week1;

/**
 * @author juancho
 */
public class QuickUnion implements Quick {

    private final int[] id;

    public QuickUnion(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (id[i] != i) i = id[i];
        return i;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }
}
