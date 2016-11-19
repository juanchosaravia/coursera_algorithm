package week2;

import static org.junit.Assert.*;

import org.junit.Test;
import week2.queue.LinkedQueueOfStrings;
import week2.queue.Queue;

/**
 * @author juancho
 */
public class QueueTest {

    @Test
    public void simpleQueueTest() {
        Queue queue = new LinkedQueueOfStrings();
        assertTrue(queue.isEmpty());
        assertNull(queue.dequeue());
        queue.enqueue("1");
        assertFalse(queue.isEmpty());
        queue.enqueue("2");
        assertFalse(queue.isEmpty());
        assertEquals("1", queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals("2", queue.dequeue());
        assertTrue(queue.isEmpty());
        queue.enqueue("1");
        assertFalse(queue.isEmpty());
        queue.enqueue("2");
        assertFalse(queue.isEmpty());
        assertEquals("1", queue.dequeue());
        assertFalse(queue.isEmpty());
        assertEquals("2", queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
