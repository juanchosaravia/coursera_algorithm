package week2;

/**
 * @author juancho
 */
public class LinkedStackOfStrings implements Stack {

    private Node first = null;

    private class Node {
        String item;
        Node node;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String pop() {
        String item = first.item;
        first = first.node;
        return item;
    }

    @Override
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.node = oldFirst;
    }
}
