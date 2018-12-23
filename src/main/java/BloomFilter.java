import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Set;

public class BloomFilter <T extends Comparable<T>> extends AbstractCollection<T> implements Set<T> {

    /**
     * Recommended use size is a multiple of 32
     */

    public BloomFilter (int size, int hashNum) {
        this.hashNum = hashNum;
        this.size = size;
        bitSet = new BitSet(size);
    }

    private BitSet bitSet;
    private int hashNum;
    private int size;
    private int counter;

    private double seed = Math.random()*103;

    private int hashCode(T object, int num) {
        int result = 0;
        String a = object.toString();
        for (int i = 0; i < object.toString().length(); i++) {
            result += (a.charAt(i)*7^(a.length()-i)) * (seed * Math.sqrt(size) * (num+2));
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