package week2.queue;

/**
 * @author juancho
 */
public interface Queue {

    void enqueue(String item);

    String dequeue();

    boolean isEmpty();
}
