package week1.assigment;

/**
 * @author juan.saravia
 */
public class Percolation {

    private final int[] id;
    private final int[] idOpen;
    private final int[] weight;

    private final int virtualP;
    private final int virtualQ;
    private final int size;

    // create n-by-n grid, with all sites blocked
    public Percolation(int size) {
        this.size = size;
        int totalSize = size * size;
        int firstBottomPos = totalSize - size;
        this.id = new int[totalSize + 2];
        this.idOpen = new int[totalSize];
        this.weight = new int[totalSize + 2];


        // virtual top
        virtualP = totalSize;
        this.id[virtualP] = virtualP;
        this.weight[virtualP] = 2;
        // virtual bottom
        virtualQ = totalSize + 1;
        this.id[virtualQ] = virtualQ;
        this.weight[virtualQ] = 2;

        for (int i = 0; i < totalSize; i++) {
            idOpen[i] = 0;
            weight[i] = 1;

            if (i < size) {
                // we are in the top face
                id[i] = virtualP;
            } else if (i >= firstBottomPos) {
                // we are at the bottom face
                id[i] = virtualQ;
            } else {
                // we are in any other face
                id[i] = i;
            }
        }
    }

    /**
     * open site (row, col) if it is not open already
     */
    public void open(int row, int col) {
        check(row, col);
        int position = getPosition(row, col);
        if (idOpen[position] == 1) return;
        idOpen[position] = 1;
        if (size == 1) {
            union(virtualP, virtualQ);
            return;
        }

        // connect with neighbourhood
        if (isLeftOpen(position, col)) {
            // has left neighbourhood
            union(position - 1, position);
        }
        if (isRightOpen(position, col)) {
            // has right neighbourhood
            union(position + 1, position);
        }
        if (isTopOpen(position, row)) {
            // has top neighbourhood
            union(position - size, position);
        }
        if (isBottomOpen(position, row)) {
            // has bottom neighbourhood
            union(position + size, position);
        }
    }

    /**
     * is site (row, col) open?
     */
    public boolean isOpen(int row, int col) {
        check(row, col);
        return idOpen[getPosition(row, col)] == 1;
    }

    /**
     * is site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        check(row, col);
        int position = getPosition(row, col);
        return idOpen[position] == 1 && connected(virtualP, position);
    }

    /**
     * does the system percolate?
     */
    public boolean percolates() {
        return connected(virtualP, virtualQ);
    }

    // region Quick-Union methods

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private void union(int p, int q) {
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

    // endregion

    private int getPosition(int row, int col) {
        return (col - 1) + ((row - 1) * size);
    }

    private boolean isBottomOpen(int position, int row) {
        return row + 1 <= size && isOpen(position + size);
    }

    private boolean isTopOpen(int position, int row) {
        return row - 1 > 0 && isOpen(position - size);
    }

    private boolean isLeftOpen(int position, int col) {
        return col - 1 > 0 && isOpen(position - 1);
    }

    private boolean isRightOpen(int position, int row) {
        return row + 1 <= size && isOpen(position + 1);
    }

    private boolean isOpen(int position) {
        return idOpen[position] == 1;
    }

    private void check(int row, int col) {
        if (row <= 0 || col <= 0 || row > size || col > size) throw new IndexOutOfBoundsException();
    }
}
