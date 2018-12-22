import org.junit.Test;
import static org.junit.Assert.*;

public class BloomFilterTest {

        @Test
        public void contains() {
            BloomFilter<Integer> bloomFilter = new BloomFilter<>(127, 3);

            assertFalse(bloomFilter.contains(0));
            assertFalse(bloomFilter.contains(-99999999));
            assertFalse(bloomFilter.contains(1000000000));
        }


}