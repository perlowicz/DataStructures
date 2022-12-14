package Stack;

import java.util.Arrays;

public class Stack<T> { //LIFO
    private T[] array;
    private int top = 0;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    void clear(){
        top = 0;
        array = (T[]) new Object[capacity];
    }

    public void push(T data){
        if (isFull())
            throw new IllegalStateException("Stack is full");

        array[top++] = data;
    }

    public T pop(){
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return array[--top];
    }

    public T peek(){
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return array[top-1];
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Empty stack";
        StringBuilder sb = new StringBuilder();
        int tempIndex = top;
        while (tempIndex > 0) {
            sb.append(array[--tempIndex])
                    .append(" ");
        }

        return sb.toString();
    }

    private boolean isEmpty(){
        return top == 0;
    }

    private boolean isFull(){
        return top == array.length;
    }

    public int getCapacity() {
        return capacity;
    }

    public T[] getArray() {
        return array;
    }
}
