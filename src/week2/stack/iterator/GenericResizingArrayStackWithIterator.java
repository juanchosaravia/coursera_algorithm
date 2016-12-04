package week2.stack.iterator;

import week2.stack.generics.GenericStack;

import java.util.Iterator;

/**
 * @author juancho
 */
public class GenericResizingArrayStackWithIterator<Item> implements GenericStack<Item>, Iterable<Item> {

    private int N;
    private Item[] stack;

    public GenericResizingArrayStackWithIterator() {
        stack = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Item pop() {
        Item item = stack[--N];
        stack[N] = null;
        if (N > 0 && N <= stack.length / 4) resize(stack.length / 2);
        return item;
    }

    public void push(Item item) {
        if (N == stack.length) resize(N * 2);
        stack[N++] = item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < stack.length; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }
    }
}
