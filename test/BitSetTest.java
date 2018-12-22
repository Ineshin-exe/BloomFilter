import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BitSetTest {

        @Test
        public void addContains() {
            BitSet bitSet1 = new BitSet(5);
            bitSet1.add(0);
            bitSet1.add(4);

            assertTrue(bitSet1.contains(0));
            assertFalse(bitSet1.contains(2));

            BitSet bitSet2 = new BitSet(100);
            bitSet2.add(0);
            bitSet2.add(10);
            bitSet2.add(50);
            bitSet2.add(100);

            assertTrue(bitSet2.contains(0));
            assertTrue(bitSet2.contains(10));
            assertTrue(bitSet2.contains(50));
            assertTrue(bitSet2.contains(100));
            assertFalse(bitSet2.contains(1));
            assertFalse(bitSet2.contains(5));
        }


}
