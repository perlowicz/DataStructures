package LinkedList.DoublyLinkedList;

import LinkedList.List;

class DoubleLinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    DoubleLinkedList() {}

    void addToFront(T data){
        Node<T> freshNode = new Node<>(data);
        if(!isEmpty()) {
            head.setPrevious(freshNode);
            freshNode.setNext(head);
        }
        head = freshNode;
        size++;
    }

    @Override
    public void push(T data){
        Node<T> freshNode = new Node<>(data);
        if (isEmpty()) {
            head = freshNode;
        }
        else {
            Node<T> currNode = head;
            while (currNode.getNext() != null){
                currNode = currNode.getNext();
            }
            currNode.setNext(freshNode);
            freshNode.setPrevious(currNode);
        }
        size++;
    }

    @Override
    public T get(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " out of bound for length: " + size);
        else if(!isEmpty()) {
            Node<T> currNode = head;
            int actualIndex = 0;
            while (currNode != null){
                if (actualIndex++ == index)
                    return currNode.getData();
                currNode = currNode.getNext();
            }
        }
        return null;
    }

    @Override
    public void removeFromFront(){
        if (!isEmpty()){
            head = head.getNext();
            head.setPrevious(null);
            size--;
        }
    }

    @Override
    public void removeFromEnd(){
        if (!isEmpty()){
            Node<T> currNode = head;
            while (currNode.getNext().getNext() != null){
                currNode = currNode.getNext();
            }
            currNode.getNext().setPrevious(null);
            currNode.setNext(null);
            size--;
        }
    }

    void clear(){
        head = null;
        size = 0;
    }

    void printForward(){
        if (!isEmpty()) {
            Node<T> currNode = head;
            System.out.print("null -> ");
            while (currNode != null){
                System.out.print(currNode.getData() + " -> ");
                currNode = currNode.getNext();
            }
            System.out.println("null");
        } else
            System.out.println("Empty list");
    }

    void printBackward(){
        if (!isEmpty()) {
            Node<T> currNode = head;
            while (currNode.getNext() != null){
                currNode = currNode.getNext();
            }
            System.out.print("null -> ");
            while (currNode != null){
                System.out.print(currNode.getData() + " -> ");
                currNode = currNode.getPrevious();
            }
            System.out.println("null");
        } else
            System.out.println("Empty list");
    }

    private boolean isEmpty(){
        return head == null;
    }

    int getSize() {
        return this.size;
    }
}
