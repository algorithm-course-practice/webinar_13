package org.example.stage1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Tree23Test {

    public static final int MAX_ITEMS = 11;

    BTree<Integer> tree;

    @BeforeEach
    void setup() {
        tree = new BTree<>(4);
    }


    @Test
    void check() {
        for (int i = 1; i < MAX_ITEMS; i++) {
            assertFalse(tree.contains(i));
            assertTrue(tree.add(i));
            assertTrue(tree.contains(i));
        }
        for (int i = 1; i < MAX_ITEMS; i++) {
            assertTrue(tree.contains(i), "i = " + i);
            assertTrue(tree.remove(i) == i);
            assertFalse(tree.contains(i));
        }
    }

    @Test
    void reverse() {
        for (int i = 1; i < MAX_ITEMS; i++) {
            assertFalse(tree.contains(i));
            assertTrue(tree.add(i));
            assertTrue(tree.contains(i));
        }
        for (int i = 10; i >= 1; i--) {
            assertTrue(tree.contains(i), "i = " + i);
            assertTrue(tree.remove(i) == i);
            assertFalse(tree.contains(i));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    })
    void random(int seed) {
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i < MAX_ITEMS; i++) {
            items.add(i);
            assertFalse(tree.contains(i));
            assertTrue(tree.add(i));
            assertTrue(tree.contains(i));
        }

        Collections.shuffle(items, new Random(seed));

        for (int i : items) {
            assertTrue(tree.contains(i), "i = " + i);
            assertTrue(tree.remove(i) == i);
            assertFalse(tree.contains(i));
        }
    }


}