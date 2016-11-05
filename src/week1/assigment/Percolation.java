package week1.assigment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author juan.saravia
 */
public class Percolation {

    private final int[] idOpen;

    private final WeightedQuickUnionUF weightedQuickUnionUF;

    private final int virtualP;
    private final int virtualQ;
    private final int size;

    // create n-by-n grid, with all sites blocked
    public Percolation(int size) {
        if (size <= 0) throw new IllegalArgumentException();
        this.size = size;
        int totalSize = size * size;
        int firstBottomPos = totalSize - size;
        idOpen = new int[totalSize];
        virtualP = totalSize;
        virtualQ = totalSize + 1;

        weightedQuickUnionUF = new WeightedQuickUnionUF(totalSize + 2);
        for (int i = 0; i < totalSize; i++) {
            if (i < size) {
                // join virtual top
                weightedQuickUnionUF.union(virtualP, i);

                // join virtual bottom
                weightedQuickUnionUF.union(virtualQ, firstBottomPos + i);
            }
            idOpen[i] = 0;
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

    private boolean connected(int p, int q) {
        return weightedQuickUnionUF.connected(p, q);
    }

    private void union(int p, int q) {
        weightedQuickUnionUF.union(p, q);
    }

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
