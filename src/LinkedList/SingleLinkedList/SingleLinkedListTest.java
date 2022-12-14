package LinkedList.SingleLinkedList;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    Random r = new Random();
    SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

    int fillUp(SingleLinkedList<Integer> linkedList){
        int randomSizeOfList = r.nextInt(30) + 10;
        for (int i = 0; i < randomSizeOfList; i++) {
            linkedList.add(r.nextInt(100));
        }
        return randomSizeOfList;
    }

    @org.junit.jupiter.api.Test
    void add() {
        linkedList.clear();
        int sizeOfList = fillUp(linkedList);
        assertEquals(sizeOfList, linkedList.getSize());
    }

    @org.junit.jupiter.api.Test
    void removeFromEnd() {
        linkedList.clear();
        fillUp(linkedList);
        Integer secondLastValue = linkedList.get(linkedList.getSize()-2);
        linkedList.removeFromEnd();
        assertEquals(secondLastValue, linkedList.get(linkedList.getSize()-1));
    }

    @org.junit.jupiter.api.Test
    void removeFromFront() {
        linkedList.clear();
        fillUp(linkedList);
        Integer secondFirstValue = linkedList.get(1);
        linkedList.removeFromFront();
        assertEquals(secondFirstValue, linkedList.get(0));
    }

    @org.junit.jupiter.api.Test
    void get() {
        linkedList.clear();
        linkedList.add(9);
        linkedList.add(7);
        linkedList.add(2);
        linkedList.add(232);
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

    @org.junit.jupiter.api.Test
    void getSize() {
        linkedList.clear();
        assertEquals(0, linkedList.getSize());
        int expectedSizeOfList = fillUp(linkedList);
        assertEquals(expectedSizeOfList, linkedList.getSize());
    }
}