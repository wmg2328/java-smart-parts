package com.wmg.smartjava.datastructure.tree;

public class BinaryTreeRunner {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(12);
        binaryTree.add(1);
        binaryTree.add(50);
        binaryTree.add(3);
        binaryTree.add(120);
        binaryTree.add(61);
        binaryTree.add(100);
        binaryTree.add(200);
        binaryTree.add(180);
        binaryTree.add(2);
        binaryTree.add(40);

        System.out.println("Tree -> " + binaryTree.toString());

        binaryTree.exists(8);

        binaryTree.maximum();

        binaryTree.minimum();

        binaryTree.delete(12);

        System.out.println("Deleted -> " + binaryTree.toString());

    }

}
