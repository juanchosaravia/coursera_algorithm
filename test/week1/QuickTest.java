package week1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author juancho
 */
public class QuickTest {

    @Test
    public void testQuickFind() {
        Quick quick = new QuickFind(10);
        assertQuick(quick);
    }

    @Test
    public void testQuickUnion() {
        Quick quick = new QuickUnion(10);
        assertQuick(quick);
    }

    @Test
    public void testQuickUnionWeighted() {
        Quick quick = new QuickUnionWeighted(10);
        assertQuick(quick);
    }

    @Test
    public void testQuickUnionWeightedCompression() {
        Quick quick = new QuickUnionWeightedCompression(10);
        assertQuick(quick);
    }

    private void assertQuick(Quick qf) {
        assertFalse(qf.connected(1, 2));
        assertTrue(qf.connected(1, 1));
        qf.union(1, 2);
        assertTrue(qf.connected(1, 2));
        qf.union(1, 3);
        qf.union(1, 4);
        assertTrue(qf.connected(2, 3));
        assertTrue(qf.connected(2, 4));
    }
}
