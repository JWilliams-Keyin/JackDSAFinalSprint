package com.keyin.bst;

public class Node {
    public int value;
    public Node left;
    public Node right;
    public int height;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
