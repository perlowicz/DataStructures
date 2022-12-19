package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> stack = new Stack<Integer>(10);

    @Test
    void pushTest(){
        Integer[] expectedValues = TestTools.fillStackAndReturnTestingValues(stack);
        assertArrayEquals(expectedValues, stack.getArray());
    }

    @Test
    void popTest(){
        stack.clear();
        Integer[] expectedValues = TestTools.fillStackAndReturnTestingValues(stack);
        for (int i = 0; i < expectedValues.length-1; i++) {
            stack.pop();
        }

        assertEquals(expectedValues[0], stack.pop());

        assertThrows(
                IllegalStateException.class,
                () -> stack.pop()
        );
    }

    @Test
    void peekTest(){
        stack.clear();
        Integer[] expectedValues = TestTools.fillStackAndReturnTestingValues(stack);
        stack.peek();
        stack.peek();
        stack.peek();
        assertEquals(expectedValues.length, stack.getCapacity());
    }
}