package week1.optionals;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * @author juancho
 */
public class SocialNetwork {

    private final int size;
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    public SocialNetwork(int size) {
        this.size = size;
        this.weightedQuickUnionUF = new WeightedQuickUnionUF(size);
    }

    public void addFriendship(int p, int q) {
        weightedQuickUnionUF.union(p, q);
    }

    public boolean areAllFriendsConnected() {
        int root = weightedQuickUnionUF.find(0);
        for (int i = 1; i < size; i++) {
            if (root != weightedQuickUnionUF.find(i)) {
                return false;
            }
        }
        return true;
    }
}
