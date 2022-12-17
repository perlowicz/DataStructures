package Tree;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T value){
        root = addNode(root, value);
    }

    private Node<T> addNode(Node<T> current, T value){
        if (current == null)
            return new Node<>(value);

        if (value.compareTo(current.getValue()) < 0){
            current.setLeft(
                    addNode(current.getLeft(), value)
            );
        } else if (value.compareTo(current.getValue()) > 0){
            current.setRight(
                    addNode(current.getRight(), value)
            );
        } else return current;

        return current;
    }

    public boolean contains(T value){
        return containsNode(root, value);
    }

    private boolean containsNode(Node<T> current, T value){
        if (current == null) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }
        return value.compareTo(current.getValue()) < 0
                ? containsNode(current.getLeft(), value)
                : containsNode(current.getRight(), value);
    }

    public void delete(T value){
        root = deleteNode(root, value);
    }

    private Node<T> deleteNode(Node<T> current, T value){
        if (current == null){
            return null;
        }
        if (value.compareTo(current.getValue()) == 0){
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }
            T smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(
                    deleteNode(current.getRight(), smallestValue)
            );
            return current;
        }
        if (value.compareTo(current.getValue()) < 0){
            current.setLeft(
                    deleteNode(current.getLeft(), value)
            );
            return current;
        }
        current.setRight(
                deleteNode(current.getRight(), value)
        );
        return current;
    }

    private T findSmallestValue(Node<T> root) {
        return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
    }

    public void traverseInOrder(Node<T> node){
        if (node != null){
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(Node<T> node){
        if (node != null) {
            System.out.print(" " + node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.print(" " + node.getValue());
        }
    }

    public Node<T> getRoot() {
        return root;
    }
}
