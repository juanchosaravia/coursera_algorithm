/**
 * @author juancho
 */
public class Percolation implements Quick{

    private final int[] id;
    private final int virtualP = 888;
    private final int virtualQ = 999;
    private final int size;

    public Percolation(int size) {
        this.size = size;
        int totalSize = size * size;
        int bottomFaceStartPos = totalSize - size - 1; // -1 just to fit the position.
        id = new int[totalSize];

        for (int i = 0; i < totalSize; i++) {

            if (i < size) {
                // we are in the top face
                id[i] = virtualP;
            } else if (i >= bottomFaceStartPos) {
                // we are at the bottom face
                id[i] = virtualQ;
            } else {
                // we are in any other face
                id[i] = i;
            }
        }
    }


    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public void union(int p, int q) {

    }
}
