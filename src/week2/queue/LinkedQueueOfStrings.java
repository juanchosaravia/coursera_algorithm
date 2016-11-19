package week2.queue;

/**
 * @author juancho
 */
public class LinkedQueueOfStrings implements Queue {

    private Node first = null;
    private Node last = null;

    @Override
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    @Override
    public String dequeue() {
        if (isEmpty()) return null;

        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        private String item;
        private Node next = null;

        public Node(String item) {
            this.item = item;
        }
    }
}
