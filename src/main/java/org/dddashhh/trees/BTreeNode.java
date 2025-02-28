package org.dddashhh.trees;

import java.util.ArrayList;

public class BTreeNode<T extends Comparable<T>> {
    private ArrayList<T> keys;
    private ArrayList<BTreeNode<T>> children;
    private boolean isLeaf;

    public BTreeNode(boolean isLeaf) {
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
        this.isLeaf = isLeaf;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public ArrayList<T> getKeys() {
        return keys;
    }

    public ArrayList<BTreeNode<T>> getChildren() {
        return children;
    }
}