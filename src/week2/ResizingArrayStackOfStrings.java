package week2;

/**
 * @author juancho
 */
public class ResizingArrayStackOfStrings implements Stack {

    private int N;
    private String[] stack;

    public ResizingArrayStackOfStrings() {
        stack = new String[1];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public String pop() {
        String item = stack[--N];
        stack[N] = null;
        if (N > 0 && N <= stack.length / 4) resize(stack.length / 2);
        return item;
    }

    @Override
    public void push(String item) {
        if (N == stack.length) resize(N * 2);
        stack[N++] = item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < stack.length; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }
}
