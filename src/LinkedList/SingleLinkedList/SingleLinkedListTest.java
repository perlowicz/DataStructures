package LinkedList.SingleLinkedList;

import LinkedList.TestTools;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {

    private SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

    @Test
    void add() {
        linkedList.clear();
        int sizeOfList = TestTools.fillUp(linkedList);
        assertEquals(sizeOfList, linkedList.getSize());
    }

    @Test
    void removeFromEnd() {
        linkedList.clear();
        TestTools.fillUp(linkedList);
        Integer firstExpectedValue = linkedList.get(linkedList.getSize()-2);
        Integer secondExpectedValue = linkedList.get(1);
        linkedList.removeFromEnd();
        linkedList.removeFromFront();

        assertEquals(
                firstExpectedValue,
                linkedList.get(linkedList.getSize()-1)
        );
        assertEquals(
                secondExpectedValue,
                linkedList.get(0)
        );
    }

    @Test
    void get() {
        linkedList.clear();
        linkedList.push(9);
        linkedList.push(7);
        linkedList.push(2);
        linkedList.push(232);
        assertEquals(7, linkedList.get(1));
        assertEquals(232, linkedList.get(3));
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.get(linkedList.getSize())
        );
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> linkedList.get(-1)
        );
    }

    @Test
    void getSize() {
        linkedList.clear();
        assertEquals(0, linkedList.getSize());
        int expectedSizeOfList = TestTools.fillUp(linkedList);
        assertEquals(expectedSizeOfList, linkedList.getSize());
    }

    @Test
    void checkReversion(){
        linkedList.clear();
        TestTools.fillUp(linkedList);
        Integer firstElementBeforeReversing = linkedList.get(0);
        Integer lastElementBeforeReversing = linkedList.get(linkedList.getSize()-1);
        linkedList.reverse();
        assertEquals(lastElementBeforeReversing, linkedList.get(0));
        assertEquals(firstElementBeforeReversing, linkedList.get(linkedList.getSize()-1));
    }
}