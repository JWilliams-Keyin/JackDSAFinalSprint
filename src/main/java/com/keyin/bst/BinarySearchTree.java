package com.keyin.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert Method
    private Node insertBST(Node currentNode, int value) {
        if (currentNode == null) {
            Node newNode = new Node();
            newNode.value = value;
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insertBST(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insertBST(currentNode.right, value);
            return currentNode;
        }
    }

    void insertBST(int value) {
        root = insertBST(root, value);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    Node search(Node node, int value) {
        if (node == null ) {
            System.out.println("Value: "+ value + " not found in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: "+ value + " found in BST");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public static Node minimumNode(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    public Node deleteNode(Node root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                Node minNodeForRight = minimumNode(root.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;

    }

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }
}
