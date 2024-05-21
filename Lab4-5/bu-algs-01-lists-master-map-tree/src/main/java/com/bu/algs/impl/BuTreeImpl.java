package com.bu.algs.impl;

import com.bu.algs.BuTree;
import lombok.Data;

public class BuTreeImpl<T extends Comparable<T>> implements BuTree<T> {

    @Data
    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    @Override
    public int size() {
        return sizeRecursive(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(T elem) {
        return containsRecursive(root, elem);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public void add(T value) {
        root = addRecursive(root, value);
    }

    @Override
    public T delete(T value) {
        throw new UnsupportedOperationException("Deletion will be implemented later");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        toStringRecursive(sb, root);
        sb.append("]");
        return sb.toString();
    }

    public void print() {
        print(root, 0);
    }

    private int sizeRecursive(Node current) {
        if (current == null) {
            return 0;
        }
        return sizeRecursive(current.left) + sizeRecursive(current.right) + 1;
    }

    private Node addRecursive(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private boolean containsRecursive(Node current, T value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value.compareTo(current.value) < 0
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    private void toStringRecursive(StringBuilder sb, Node current) {
        if (current == null) {
            // do nothing
            return;
        }

        sb.append(current.value).append(" ");
        toStringRecursive(sb, current.left);
        toStringRecursive(sb, current.right);
    }

    private void print(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 5;

        // Process right child first
        print(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 5; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");

        // Process left child
        print(root.left, space);
    }
}
