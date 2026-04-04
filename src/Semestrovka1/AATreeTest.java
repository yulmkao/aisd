package Semestrovka1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AATreeTest {

    @Test
    void testGettersSetters() {
        Node node = new Node(42, 1, null, null);
        assertEquals(42, node.getValue());
        assertEquals(1, node.getLevel());
        node.setValue(43);
        assertEquals(43, node.getValue());
    }

    @Test
    void testInsertAndFind() {
        AATree tree = new AATree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        assertTrue(tree.find(10));
        assertTrue(tree.find(20));
        assertFalse(tree.find(100));
    }

    @Test
    void testDelete() {
        AATree tree = new AATree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.delete(30);
        assertFalse(tree.find(30));
        assertTrue(tree.find(50));
        assertTrue(tree.find(70));
    }

    @Test
    void testEmptyTree() {
        AATree tree = new AATree();
        assertFalse(tree.find(1));
    }
}