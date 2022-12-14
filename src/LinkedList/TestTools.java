package LinkedList;

import java.util.Random;

public class TestTools {

    private static Random r = new Random();

    public static int fillUp(List<Integer> linkedList){
        int randomSizeOfList = r.nextInt(30) + 10;
        for (int i = 0; i < randomSizeOfList; i++) {
            linkedList.push(r.nextInt(100));
        }
        return randomSizeOfList;
    }
}
