package week2.stack.generics;

/**
 * @author juancho
 */
public class GenericLinkedStack<T> implements GenericStack<T> {

    private Node first = null;

    private class Node {
        T item;
        Node node;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T pop() {
        T item = first.item;
        first = first.node;
        return item;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.node = oldFirst;
    }
}
