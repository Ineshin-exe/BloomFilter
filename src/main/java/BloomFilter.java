import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Set;

public class BloomFilter <T extends Comparable<T>> extends AbstractCollection<T> implements Set<T> {

    public BloomFilter (int size, int hashNum) {

        this.hashNum = hashNum;
        this.size = size;
        bitSet = new BitSet(size);
    }

    private BitSet bitSet;
    private int hashNum;
    private int size;

    private int hashCode(T object, int num) {

        int result = 0;

        for (int i = 0; i < object.toString().length(); i++) {

            result += (num * 32) + 85 + object.toString().charAt(i);
        }

        return result % size;
    }

    public boolean add(T object) {

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
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
