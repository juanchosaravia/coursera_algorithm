package week1;

/**
 * week1.Quick Union Weighted with Path Compression algorithm.
 *
 * @author juancho
 */
public class QuickUnionWeightedCompression implements Quick {

    private final int[] id;
    private final int[] weight;

    public QuickUnionWeightedCompression(int size) {
        weight = new int[size];
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            weight[i] = 1;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
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
        if (pRoot == qRoot) return;

        int pWeight = weight[pRoot];
        int qWeight = weight[qRoot];
        if (pWeight <= qWeight) {
            id[pRoot] = qRoot;
            weight[qRoot] += pWeight;
        } else {
            id[qRoot] = pRoot;
            weight[pRoot] += qWeight;
        }
    }
}
