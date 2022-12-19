package Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    public void addingAndContainingTest(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(9);
        binaryTree.add(3);
        binaryTree.add(4);

        binaryTree.traverseInOrder(binaryTree.getRoot());
        System.out.println();
        binaryTree.traversePostOrder(binaryTree.getRoot());
        System.out.println();
        binaryTree.traversePreOrder(binaryTree.getRoot());

        assertTrue(binaryTree.contains(1));
        assertTrue(binaryTree.contains(2));
        assertTrue(binaryTree.contains(3));
        assertTrue(binaryTree.contains(4));
        assertFalse(binaryTree.contains(5));
    }

    @Test
    public void deletingTest(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(1);
        binaryTree.add(9);
        binaryTree.add(2);

        assertTrue(binaryTree.contains(1));
        binaryTree.delete(1);
        assertFalse(binaryTree.contains(1));

        assertTrue(binaryTree.contains(2));
        binaryTree.delete(2);
        assertFalse(binaryTree.contains(2));

        assertTrue(binaryTree.contains(9));
    }

}