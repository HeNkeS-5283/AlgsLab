package com.bu.algs.impl;

import com.bu.algs.BuTree;

public class MyTree<prototipe extends Comparable<prototipe>> implements BuTree<prototipe> {
    private class Node {
        prototipe value;
        Node left, right;

        public Node(prototipe value) {
            this.value = value;
        }
    }
    Node root;

    @Override
    public int size() {
        return sizeRecorse(root);
    }

    private int sizeRecorse(Node current){
        if(current == null) {
            return 0;
        }
        return sizeRecorse(current.left) + 1 + sizeRecorse(current.right);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(prototipe elem) {
        return containsRecorse(root, elem);
    }

    private boolean containsRecorse(Node current, prototipe value){
        if(current == null){
            return false;
        }
        if(current.value.equals(value)){
            return true;
        }
        if(current.value.compareTo(value) > 0){
            return containsRecorse(current.left, value);
        }
        else {
            return containsRecorse(current.right, value);
        }
    }

    @Override
    public void clear() {
         root = null;
    }

    @Override
    public void add(prototipe value) {
        root = addRecorse(root, value);
    }

    private Node addRecorse(Node current, prototipe value){
        if(current == null) {
            return new Node(value);
        }
        if(current.value.compareTo(value) < 0) {
            current.right = addRecorse(current.right, value);
        }
         else if (current.value.compareTo(value) > 0) {
            current.left = addRecorse(current.left,value);
        }
         else {
             return current;
        }
         return current;
    }

    @Override
    public prototipe delete(prototipe value) {
        Node deletedNode = new Node(null);
        root = deleteRecorse(root, value, deletedNode);
        return deletedNode.value;
    }

    public Node deleteRecorse(Node current, prototipe value, Node deletedNode) {
        if (current == null) {
            return null;
        }

        if (current.value.compareTo(value) == 0) {
            prototipe deletedValue = current.value;

            if (current.left == null && current.right == null) {

                if (current == root) {
                    root = null;
                }
                deletedNode.value = deletedValue;
                return null;

            } else if (current.left == null) {

                if (current == root) {
                    root = current.right;
                }
                deletedNode.value = deletedValue;
                return current.right;

            } else if (current.right == null) {

                if (current == root) {
                    root = current.left;
                }
                deletedNode.value = deletedValue;
                return current.left;

            } else {

                Node smallestValueNode = findSmallestValue(current.right);

                current.value = smallestValueNode.value;
                current.right = deleteRecorse(current.right, smallestValueNode.value, deletedNode);

                return current;
            }
        }

        if (current.value.compareTo(value) > 0) {
            current.left = deleteRecorse(current.left, value, deletedNode);
        } else {
            current.right = deleteRecorse(current.right, value, deletedNode);
        }
        return current;
    }

    private Node findSmallestValue(Node root) {
        return root.left == null ? root : findSmallestValue(root.left);
    }

    @Override
    public void print() {
        System.out.println("\tTree");
        printRecorse(root, 5);
    }

    private void printRecorse(Node current, int space){
        if(current == null){
            return;
        }

        space += 4;

        printRecorse(current.right, space);


        System.out.println();
        for (int i = 4; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(current.value);


        printRecorse(current.left, space);
    }

}
