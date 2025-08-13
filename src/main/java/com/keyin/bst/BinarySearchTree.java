package com.keyin.bst;

import java.util.List;

public class BinarySearchTree {
    private Node root;

    private Node insertBST(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value <= currentNode.value) {
            currentNode.left = insertBST(currentNode.left, value);
        } else {
            currentNode.right = insertBST(currentNode.right, value);
        }
        return currentNode;
    }
    public void insertBST(int value) {
        root = insertBST(root, value);
    }

    public void insertAll(List<Integer> bstNumbers) {
        for (int number : bstNumbers) {
            insertBST(number);
        }
    }

    public Node getRoot() {
        return root;
    }
}
