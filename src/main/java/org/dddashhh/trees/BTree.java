package org.dddashhh.trees;

import java.util.ArrayList;
import java.util.List;

public class BTree<T extends Comparable<T>> {
    private final int degree;
    private BTreeNode<T> root;
    private List<String> log;

    public BTree(int degree) {
        if (degree < 2) {
            throw new IllegalArgumentException("Degree must be at least 2");
        }
        this.degree = degree;
        this.root = new BTreeNode<>(true);
        this.log = new ArrayList<>();
    }

    public List<String> getLog() {
        return log;
    }

    public void resetLog() {
        log.clear();
    }

    public void insert(T key) {
        log.add("insert_start: " + key);
        BTreeNode<T> r = root;
        if (r.getKeys().size() == 2 * degree - 1) {
            log.add("split_root");
            BTreeNode<T> s = new BTreeNode<>(false);
            root = s;
            s.getChildren().add(r);
            splitChild(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
        log.add("insert_end: " + key);
    }

    private void insertNonFull(BTreeNode<T> node, T key) {
        log.add("insert_non_full: " + key);
        int i = node.getKeys().size() - 1;

        if (node.isLeaf()) {
            log.add("insert_leaf: " + key);
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) {
                i--;
            }
            node.getKeys().add(i + 1, key);
        } else {
            while (i >= 0 && key.compareTo(node.getKeys().get(i)) < 0) {
                i--;
            }
            i++;
            log.add("descend_to_child: " + i);
            if (node.getChildren().get(i).getKeys().size() == 2 * degree - 1) {
                log.add("split_child: " + i);
                splitChild(node, i);
                if (key.compareTo(node.getKeys().get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(node.getChildren().get(i), key);
        }
    }

    private void splitChild(BTreeNode<T> parent, int index) {
        log.add("split_child_start: " + index);
        BTreeNode<T> fullChild = parent.getChildren().get(index);
        BTreeNode<T> newChild = new BTreeNode<>(fullChild.isLeaf());

        for (int j = 0; j < degree - 1; j++) {
            newChild.getKeys().add(fullChild.getKeys().remove(degree));
        }
        if (!fullChild.isLeaf()) {
            for (int j = 0; j < degree; j++) {
                newChild.getChildren().add(fullChild.getChildren().remove(degree));
            }
        }

        parent.getChildren().add(index + 1, newChild);
        parent.getKeys().add(index, fullChild.getKeys().remove(degree - 1));
        log.add("split_child_end: " + index);
    }

    public boolean search(T key) {
        log.add("search_start: " + key);
        boolean found = search(root, key) != null;
        log.add("search_end: " + key + ", found: " + found);
        return found;
    }

    private BTreeNode<T> search(BTreeNode<T> node, T key) {
        int i = 0;
        while (i < node.getKeys().size() && key.compareTo(node.getKeys().get(i)) > 0) {
            i++;
        }
        if (i < node.getKeys().size() && key.compareTo(node.getKeys().get(i)) == 0) {
            log.add("search_found: " + key);
            return node;
        }
        if (node.isLeaf()) {
            log.add("search_not_found: " + key);
            return null;
        }
        log.add("search_descend: " + i);
        return search(node.getChildren().get(i), key);
    }
}