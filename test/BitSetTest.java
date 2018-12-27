import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BitSetTest {

    @Test
    public void add() {
        BitSet bitSet1 = new BitSet(5);
        bitSet1.add(0);
        bitSet1.add(4);

        int[] a = new int[1];
        a[0] = 17;

        assertEquals(Arrays.toString(a), bitSet1.toString());

        BitSet bitSet2 = new BitSet(0);

        int[] a2 = new int[0];

        assertEquals(Arrays.toString(a2), bitSet2.toString());

        try {
            BitSet bitSet3 = new BitSet(1023);
            bitSet3.add(1024);
            bitSet3.add(1025);
            bitSet3.add(1026);
            bitSet3.add(3);

            int[] a3 = new int[32];
            a3[0] = 8;

            assertEquals(Arrays.toString(a3), bitSet3.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("The elements exceeds the value. True");
        }

        BitSet bitSet4 = new BitSet(1024);
        bitSet4.add(0);
        bitSet4.add(1);
        bitSet4.add(2);
        bitSet4.add(3);

        int[] a4 = new int[32];
        a4[0] = 15;

        assertEquals(Arrays.toString(a4), bitSet4.toString());
    }

    @Test
    public void contains() {
        BitSet bitSet1 = new BitSet(5);

        bitSet1.add(0);
        bitSet1.add(4);

        assertTrue(bitSet1.contains(0));
        assertTrue(bitSet1.contains(4));
        assertFalse(bitSet1.contains(5));

        BitSet bitSet2 = new BitSet(0);

        assertFalse(bitSet2.contains(0));
        assertFalse(bitSet2.contains(4));
        assertFalse(bitSet2.contains(5));

        try {
            BitSet bitSet3 = new BitSet(1024);

            assertFalse(bitSet3.contains(1025));
            assertFalse(bitSet3.contains(1026));
            assertFalse(bitSet3.contains(2019));
        } catch (IllegalArgumentException e) {
            System.out.println("The elements exceeds the value. True");
        }

    }

}
