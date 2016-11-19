package week2.stack;

/**
 * @author juancho
 */
public class FixedCapacityStackOfStrings implements Stack {

    private int N;
    private final String[] items;

    public FixedCapacityStackOfStrings(int capacity) {
        this.items = new String[capacity];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public String pop() {
        String item = items[--N];
        items[N] = null;
        return item;
    }

    @Override
    public void push(String item) {
        items[N++] = item;
    }
}
