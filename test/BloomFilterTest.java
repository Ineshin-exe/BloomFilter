import org.junit.Test;
import static org.junit.Assert.*;

public class BloomFilterTest {

        @Test
        public void contains() {
            BloomFilter<Integer> bloomFilter = new BloomFilter<>(128, 3);

            assertFalse(bloomFilter.contains(0));
            assertFalse(bloomFilter.contains(-99999999));
            assertFalse(bloomFilter.contains(1000000000));
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

        BloomFilter<Integer> bloomFilter2 = new BloomFilter<>(32, 3);

        assertEquals(0, bloomFilter2.size());
    }


}