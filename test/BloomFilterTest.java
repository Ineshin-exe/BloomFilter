import org.junit.Test;

import static org.junit.Assert.*;

public class BloomFilterTest {

    @Test
    public void add() {
        BloomFilter<Integer> bloomFilter = new BloomFilter<>(128, 3);

        bloomFilter.add(0);
        bloomFilter.add(1);
        bloomFilter.add(2);

        assertTrue(bloomFilter.contains(0));
        assertTrue(bloomFilter.contains(1));
        assertTrue(bloomFilter.contains(2));

        try {
            BloomFilter<Integer> bloomFilter1 = new BloomFilter<>(0, 3);

            bloomFilter1.add(0);
            bloomFilter1.add(1);
            bloomFilter1.add(2);
        } catch (IllegalArgumentException e) {
            System.out.println("Bloom Filter can not be 0. True");
        }

        try {
            BloomFilter<Integer> bloomFilter2 = new BloomFilter<>(-490, 3);

            bloomFilter2.add(0);
            bloomFilter2.add(1);
            bloomFilter2.add(2);
        } catch (IllegalArgumentException e) {
            System.out.println("Bloom Filter can not be negative. True");
        }

        BloomFilter<Integer> bloomFilter3 = new BloomFilter<>(64, 3);

        bloomFilter3.add(-2147483648);
        bloomFilter3.add(1024);
        bloomFilter3.add(2147483647);

        assertTrue(bloomFilter3.contains(-2147483648));
        assertTrue(bloomFilter3.contains(1024));
        assertTrue(bloomFilter3.contains(2147483647));
    }

    @Test
    public void contains() {
        BloomFilter<Integer> bloomFilter = new BloomFilter<>(128, 3);

        bloomFilter.add(0);
        bloomFilter.add(1);
        bloomFilter.add(2);

        assertTrue(bloomFilter.contains(0));
        assertTrue(bloomFilter.contains(1));
        assertTrue(bloomFilter.contains(2));

        try {
            assertFalse(bloomFilter.contains(10));
            assertFalse(bloomFilter.contains(20));
            assertFalse(bloomFilter.contains(30));
        } catch (AssertionError e) {
            System.out.println("False positive. Probably true @first");
        }

        BloomFilter<Integer> bloomFilter1 = new BloomFilter<>(3, 3);

        bloomFilter1.add(0);
        bloomFilter1.add(1);
        bloomFilter1.add(2);

        assertTrue(bloomFilter1.contains(0));
        assertTrue(bloomFilter1.contains(1));
        assertTrue(bloomFilter1.contains(2));

        try {
            assertFalse(bloomFilter1.contains(10));
            assertFalse(bloomFilter1.contains(20));
            assertFalse(bloomFilter1.contains(30));
        } catch (AssertionError e) {
            System.out.println("False positive. Probably true @second");
        }

        BloomFilter<Integer> bloomFilter3 = new BloomFilter<>(64, 3);

        bloomFilter3.add(-2147483648);
        bloomFilter3.add(1024);
        bloomFilter3.add(2147483647);

        assertTrue(bloomFilter3.contains(-2147483648));
        assertTrue(bloomFilter3.contains(1024));
        assertTrue(bloomFilter3.contains(2147483647));

        BloomFilter<Integer> bloomFilter4 = new BloomFilter<>(64, 3);

        assertFalse(bloomFilter4.contains(-2147483648));
        assertFalse(bloomFilter4.contains(1024));
        assertFalse(bloomFilter4.contains(2147483647));
    }


    @Test
    public void size() {
        BloomFilter<Integer> bloomFilter = new BloomFilter<>(128, 3);

        bloomFilter.add(1);
        bloomFilter.add(5);
        bloomFilter.add(4);
        bloomFilter.add(3);
        bloomFilter.add(2);
        bloomFilter.add(11);
        bloomFilter.add(12);

        assertEquals(7, bloomFilter.size());

        BloomFilter<Integer> bloomFilter1 = new BloomFilter<>(32, 3);

        assertEquals(0, bloomFilter1.size());

        BloomFilter<Integer> bloomFilter2 = new BloomFilter<>(32, 3);

        assertNotEquals(32, bloomFilter2.size());
    }


}