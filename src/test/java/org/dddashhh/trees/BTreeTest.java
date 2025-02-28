package org.dddashhh.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BTreeTest {
    @Test
    public void testInsertLogLargeTree() {
        BTree<Integer> bTree = new BTree<>(3);

        for (int i = 1; i <= 15; i++) {
            bTree.insert(i);
        }

        List<String> log = bTree.getLog();

        assertTrue(log.contains("split_root"));

        assertTrue(log.stream().filter(entry -> entry.startsWith("split_child_start:")).count() > 1);

        assertTrue(log.get(log.size() - 1).startsWith("insert_end: 15"));
    }

    @Test
    public void testSearchLogLargeTree() {
        BTree<Integer> bTree = new BTree<>(3);

        for (int i = 1; i <= 15; i++) {
            bTree.insert(i);
        }

        bTree.resetLog();

        boolean found = bTree.search(10);
        List<String> log = bTree.getLog();

        assertTrue(found);
        assertTrue(log.contains("search_start: 10"));
        assertTrue(log.contains("search_found: 10"));

        long descendSteps = log.stream().filter(entry -> entry.startsWith("search_descend:")).count();
        assertTrue(descendSteps > 0);

        bTree.resetLog();

        boolean notFound = bTree.search(100);
        log = bTree.getLog();

        assertFalse(notFound);
        assertTrue(log.contains("search_start: 100"));
        assertTrue(log.contains("search_not_found: 100"));
    }

    @Test
    public void testInsertAndSplitMultipleLevels() {
        BTree<Integer> bTree = new BTree<>(3);

        for (int i = 1; i <= 30; i++) {
            bTree.insert(i);
        }

        List<String> log = bTree.getLog();

        long splitCount = log.stream().filter(entry -> entry.startsWith("split_child_start:")).count();
        assertTrue(splitCount > 3, "Expected multiple splits, but found: " + splitCount);

        assertTrue(log.get(log.size() - 1).startsWith("insert_end: 30"));
    }

    @Test
    public void testSearchInDeepTree() {
        BTree<Integer> bTree = new BTree<>(3);

        for (int i = 1; i <= 50; i++) {
            bTree.insert(i);
        }

        bTree.resetLog();

        boolean found = bTree.search(25);
        List<String> log = bTree.getLog();

        assertTrue(found);
        assertTrue(log.contains("search_start: 25"));
        assertTrue(log.contains("search_found: 25"));

        long descendSteps = log.stream().filter(entry -> entry.startsWith("search_descend:")).count();
        assertTrue(descendSteps > 1, "Expected multiple descend steps, but found: " + descendSteps);

        bTree.resetLog();

        boolean notFound = bTree.search(100);
        log = bTree.getLog();

        assertFalse(notFound);
        assertTrue(log.contains("search_start: 100"));
        assertTrue(log.contains("search_not_found: 100"));

        descendSteps = log.stream().filter(entry -> entry.startsWith("search_descend:")).count();
        assertTrue(descendSteps > 1, "Expected multiple descend steps, but found: " + descendSteps);
    }
}