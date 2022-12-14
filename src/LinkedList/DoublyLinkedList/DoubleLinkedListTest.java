package LinkedList.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

import LinkedList.TestTools;
import org.junit.jupiter.api.Test;


class DoubleLinkedListTest {

    DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

    @Test
    void getTest(){
        doubleLinkedList.clear();
        doubleLinkedList.push(1);
        doubleLinkedList.push(2);
        doubleLinkedList.push(3);
        doubleLinkedList.push(4);

        assertEquals(3, doubleLinkedList.get(2));
        assertEquals(1, doubleLinkedList.get(0));
        assertEquals(4, doubleLinkedList.get(doubleLinkedList.getSize()-1));
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> doubleLinkedList.get(doubleLinkedList.getSize())
        );
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> doubleLinkedList.get(-1)
        );
    }

    @Test
    void pushTest(){
        doubleLinkedList.clear();
        TestTools.fillUp(doubleLinkedList);
        doubleLinkedList.push(99);

        assertEquals(99, doubleLinkedList.get(doubleLinkedList.getSize()-1));
    }

    @Test
    void removeTest(){
        doubleLinkedList.clear();
        TestTools.fillUp(doubleLinkedList);
        Integer lastExpectedElement = doubleLinkedList.get(doubleLinkedList.getSize() - 2);
        Integer firstExpectedElement = doubleLinkedList.get(1);
        doubleLinkedList.removeFromEnd();
        doubleLinkedList.removeFromFront();

        assertEquals(
                lastExpectedElement,
                doubleLinkedList.get(doubleLinkedList.getSize()-1)
        );
        assertEquals(
                firstExpectedElement,
                doubleLinkedList.get(0)
        );
    }
}