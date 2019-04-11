import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Set;

public class BloomFilter <T extends Comparable<T>> extends AbstractCollection<T> implements Set<T> {

    /**
     * Recommended use size is a multiple of 32
     */

    private final BitSet bitSet;
    private final double seed = Math.random()*103;

    private final int hashNum;
    private final int size;

    private int counter;

    public BloomFilter (final int size, final int hashNum) {
        if (size <= 0) throw new IllegalArgumentException("Size of BloomFilter can not be 0 or negative");
        this.hashNum = hashNum;
        this.size = size;
        bitSet = new BitSet(size);
    }

    private int hashCode(T object, int num) {
        int result = 0;
        String forHashCode = object.toString();
        for (int i = 0; i < object.toString().length(); i++) {
            result += (forHashCode.charAt(i)*7^(forHashCode.length()-i)) * (seed * Math.sqrt(size) * (num+2));
        }
        return result % size;
    }

    public boolean add(T object) {
        counter++;
        for(int i = 0; i < hashNum; i++) {
            bitSet.add(hashCode(object, i));
        }
        return false;
    }

    public boolean contains(T object) {
        int count = 0;
        for(int i = 0; i < hashNum; i++) {
            if (bitSet.contains(hashCode(object, i))) count ++;
        }
        return count == hashNum;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Method can not be realised");
    }


    @Override
    public int size() {
        return counter;
    }
}