package week2.assigment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author juancho
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first = null;
    private Node last = null;

    public static void main(String[] args) {

    }

    public int size() {
        int count = 0;
        for (Item item : this) {
            count++;
        }
        return count;
    }

    public void addFirst(Item item) {
        checkNull(item);
        Node oldFirst = first;
        first = new Node(item);
        if (isEmpty()) {
            first = last;
        } else {
            first.next = oldFirst;
        }

    }

    public void addLast(Item item) {
        checkNull(item);
        Node oldLast = last;
        last = new Node(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = last.item;
        Node preLast = getPreLast();
        if (preLast == null) {
            // first and last are the same, clean stack
            first = last = null;
        } else {
            last = preLast;
            last.next = null;
        }
        return item;
    }

    private Node getPreLast() {
        if (first == last) return null;
        Node pre = first;
        while (pre.next != null) {
            if (pre.next.next == null) {
                break;
            }
            pre = pre.next;
        }
        return pre;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private void checkNull(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private class Node {
        private Item item;
        private Node next = null;

        public Node(Item item) {
            this.item = item;
        }
    }

    private class DequeIterator implements Iterator<Item> {

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            if (node == null) {
                throw new NoSuchElementException();
            }
            Item item = node.item;
            node = node.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
