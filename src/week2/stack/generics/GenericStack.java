package week2.stack.generics;

/**
 * @author juancho
 */
public interface GenericStack<Item> {

    boolean isEmpty();

    Item pop();

    void push(Item item);
}
