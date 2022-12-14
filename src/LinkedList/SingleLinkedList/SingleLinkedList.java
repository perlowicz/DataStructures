package LinkedList.SingleLinkedList;

import LinkedList.List;

public class SingleLinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    SingleLinkedList(){}

    @Override
    public void push(T data){
        if (isEmpty())
            head = new Node<>(data);
        else {
            Node<T> tempNode = head;
            while (tempNode.getNext() != null){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(new Node<>(data));
        }
        size++;
    }

    @Override
    public void removeFromEnd(){
        if (!isEmpty()){
            Node<T> tempNode = head;
            while (tempNode.getNext().getNext() != null){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            size--;
        }
    }

    @Override
    public void removeFromFront(){
        if (!isEmpty() && head.getNext() != null){
            head = head.getNext();
            size--;
        }
    }

    @Override
    public T get(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " out of bound for length: " + size);
        else if(!isEmpty()){
            Node<T> tempNode = head;
            int indexCounter = 0;
            while (tempNode != null){
                if (indexCounter++ == index){
                    return tempNode.getData();
                }
                tempNode = tempNode.getNext();
            }
        }
        return null;
    }

    void clear(){
        head = null;
        size = 0;
    }

    void reverse(){
        Node<T> next;
        Node<T> curr = head;
        Node<T> prev = null;
        while (curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    void print(){
        if (isEmpty())
            System.out.println("Empty list");
        else {
            Node<T> tempNode = head;
            System.out.print("head: ");
            while (tempNode.getNext() != null){
                System.out.print(tempNode.getData() + " -> ");
                tempNode = tempNode.getNext();
            }
            System.out.println(tempNode.getData() + " -> null");
        }
    }

    int getSize() {
        return size;
    }

    private boolean isEmpty(){
        return head == null;
    }
}
