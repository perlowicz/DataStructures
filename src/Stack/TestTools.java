package Stack;

import java.util.Random;

public class TestTools {

    private static Random r = new Random();

    static Integer[] fillStackAndGetTestingValues(Stack<Integer> stack){
        Integer[] testingArray = new Integer[stack.getCapacity()];
        for (int i = 0; i < stack.getCapacity(); i++) {
            int randomNumber = r.nextInt(100);
            stack.push(randomNumber);
            testingArray[i] = randomNumber;
        }
        return testingArray;
    }
}
