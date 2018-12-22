import java.util.Arrays;

public class BitSet {

    private int[] set;
    private final static int BIT_SET = 32;
    private int size;

    /**
     * Constructs a new, empty BitSet;
     * @param size is a size of BitSet.
     */

    BitSet(int size) {
        this.set = new int[size / BIT_SET + 1];
        this.size = size;
    }
    /**
     * Adds number in the BitSet
     * @param num number that adds to the BitSet.
     * @throws IllegalArgumentException sets a number larger than the BitSet size.
     */
    void add (int num) {
        if (num <= size && num >= 0) {
            int a = num / BIT_SET;
            int b = num % BIT_SET;
            if ((set[a] & (1 << b)) == 0) {
                set[a] = set[a] ^ (1 << b);
            }
        } else {
            throw new IllegalArgumentException("The element exceeds the value");
        }
    }

    /**
     * Checks a number in the BitSet
     * @param num number that check in the BitSet.
     * @throws IllegalArgumentException sets a number larger than the BitSet size.
     */
    boolean contains (int num) {
        if (num <= size && num >= 0) {
            int a = set[num / BIT_SET];
            int b = num % BIT_SET;
            return (a & (1 << b)) != 0;
        } else {
            throw new IllegalArgumentException("The element exceeds the value");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(set);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitSet BitSet = (BitSet) o;
        return Arrays.equals(set, BitSet.set);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(set);
    }
}