package com.wmg.smartjava.datastructure.tree;

public class BinaryTree {

    private Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
        }

        return current;
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.getValue()) {
            // Node delete strategies
            // 1 - If node has no children
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // 2 - If one node available
            if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            // 3 - if 2 node is available
            int smallestValue = findSmallestRecursive(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;

        }

        if (value > current.getValue()) {
            current.setRight(deleteRecursive(current.getRight(), value));
        } else if (value < current.getValue()) {
            current.setLeft(deleteRecursive(current.getLeft(), value));
        }
        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        return current != null && (current.getValue() == value || (current.getValue() > value ? containsNodeRecursive(current.getLeft(), value) : containsNodeRecursive(current.getRight(), value)));
    }

    private int findSmallestRecursive(Node root) {
        return root.getLeft() == null ? root.getValue() : findSmallestRecursive(root.getLeft());
    }

    private Node getMaximumRecursive(Node current) {

        if (current.getLeft() == null && current.getRight() == null) {
            return current;
        }

        if (current.getRight() == null) {
            return current;
        }

        return getMaximumRecursive(current.getRight());
    }

    private Node getMinimumRecursive(Node current) {

        if (current.getLeft() == null && current.getRight() == null) {
            return current;
        }

        if (current.getLeft() == null) {
            return current;
        }

        return getMinimumRecursive(current.getLeft());
    }

    public void add(int value) {
        if (this.root == null) {
            this.root = addRecursive(root, value);
        }
        addRecursive(root, value);
    }

    public boolean exists(int value) {
        return containsNodeRecursive(root, value);
    }

    public void maximum() {
        Node maximumNode = getMaximumRecursive(root);
        System.out.println("Maximum -> " + maximumNode);
    }

    public void minimum() {
        Node minimumNode = getMinimumRecursive(root);
        System.out.println("Minimum -> " + minimumNode);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
        System.out.println(root);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
