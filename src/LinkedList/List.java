package LinkedList;

public interface List<T> {
    void push(T data);
    void removeFromFront();
    void removeFromEnd();
    T get(int index);
}
