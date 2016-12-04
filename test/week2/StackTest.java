package week2;

import static org.junit.Assert.*;

import org.junit.Test;
import week2.stack.FixedCapacityStackOfStrings;
import week2.stack.LinkedStackOfStrings;
import week2.stack.ResizingArrayStackOfStrings;
import week2.stack.Stack;
import week2.stack.generics.GenericLinkedStack;
import week2.stack.generics.GenericResizingArrayStack;
import week2.stack.generics.GenericStack;
import week2.stack.iterator.GenericResizingArrayStackWithIterator;

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

    @Test
    public void genericLinkedStack() {
        assertGenericStack(new GenericLinkedStack<String>());
    }

    @Test
    public void genericResizingArrayStack() {
        assertGenericStack(new GenericResizingArrayStack<String>());
    }

    @Test
    public void stackIterator() {
        GenericResizingArrayStackWithIterator<Integer> stack = new GenericResizingArrayStackWithIterator<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer val = 3;
        for (Integer integer : stack) {
            assertEquals(val, integer);
            val--;
        }
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

    private void assertGenericStack(GenericStack<String> stack) {
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
