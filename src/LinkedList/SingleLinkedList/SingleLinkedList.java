package LinkedList.SingleLinkedList;

public class SingleLinkedList<T> {

    private Node<T> head;
    private int size;

    public SingleLinkedList(Node<T> head) {
        this.head = head;
        size++;
    }

    public SingleLinkedList(){}

    public void add(T data){
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

    public void removeFromFront(){
        if (!isEmpty() && head.getNext() != null){
            head = head.getNext();
            size--;
        }
    }

    public T get(int index){
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + " out of bound for length: " + size);
        else {
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

    public void clear(){
        head = null;
        size = 0;
    }

    public void printList(){
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

    public int getSize() {
        return size;
    }

    private boolean isEmpty(){
        return head == null;
    }
}
