package week2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author juancho
 */
public class StackTest {

    @Test
    public void linkedStackOfStringTest() {
        assertStack(new LinkedStackOfStrings());
    }

    @Test
    public void fixedCapaticyStackOfStringTest() {
        assertStack(new FixedCapacityStackOfStrings(10));
    }

    @Test
    public void ResizingArrayStackOfStringTest() {
        assertStack(new ResizingArrayStackOfStrings());
    }

    private void assertStack(Stack stack) {
        assertTrue(stack.isEmpty());
        stack.push("Hola");
        assertEquals("Pop didn't work.", "Hola", stack.pop());
        stack.push("Mundo");
        stack.push("Loco");
        assertEquals("Pop didn't work.", "Loco", stack.pop());
        assertEquals("Pop didn't work.", "Mundo", stack.pop());
        assertTrue(stack.isEmpty());
    }
}
