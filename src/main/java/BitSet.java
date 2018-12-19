import java.util.Arrays;

public class BitSet {

    public boolean[] elements;

    BitSet(int size) {
        this.elements = new boolean[size];
    }

    public int getSize() {
        return elements.length;
    }

    public boolean[] getElements(){
        return elements;
    }

    public void add (int element) {
        if (element < getSize() && element >= 0) {
            elements[element] = true;
        } else {
            throw new IllegalArgumentException("The element exceeds the value");
        }
    }

    public void addAll (int[] element) {
        for (int i = 0; i < element.length; i++) {
            add(element[i]);
        }
    }

    public void delete (int element) {
        if (element <= getSize() && element >= 0) {
            elements[element] = false;
        } else {
            throw new IllegalArgumentException("The element exceeds the value");
        }
    }

    public void deleteAll (int[] element) {
        for (int i = 0; i < element.length; i++) {
            delete(element[i]);
        }
    }

    public boolean contains (int element) {
        if (element <= getSize()) {
            return elements[element];
        } else {
            throw new IllegalArgumentException("The element exceeds the maximum value");
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitSet BitSet = (BitSet) o;
        return Arrays.equals(elements, BitSet.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}