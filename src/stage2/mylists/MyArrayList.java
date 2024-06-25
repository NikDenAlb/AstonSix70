package stage2.mylists;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Tutorial class with a simple ArrayList implementation
 *
 * @author Denis Nikulin
 */
public class MyArrayList<E> {
    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * initial capacity is 5. Expand by 5 when it's crowded
     * collapses by 10 if 20 elements are missing
     */
    private Object[] elementData;

    /**
     * Construct an empty list with an initial capacity of 5.
     */
    public MyArrayList() {
        this.size = 0;
        this.elementData = new Object[5];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public boolean add(E e) {
        if (elementData.length == size) {
            elementData = Arrays.copyOf(elementData, size + 5);
        }
        elementData[size++] = e;
        return true;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E remove(int index) {
        Objects.checkIndex(index, size);

        @SuppressWarnings("unchecked") E oldValue = (E) elementData[index];

        final int newSize;
        if ((newSize = size - 1) > index) {
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        }
        size = newSize;

        if (elementData.length - 20 == size) {
            elementData = Arrays.copyOf(elementData, elementData.length - 10);
        }
        return oldValue;
    }

    /**
     * get the element by index
     *
     * @param index the index of the element to be removed
     * @return the element
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * get size of the array
     *
     * @return size of the array
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }

    /**
     * Extra method to see some guts
     *
     * @return size of the array
     */
    public int dataSize() {
        return elementData.length;
    }


    /**
     * Extra method to see some guts
     *
     * @return raw elementData
     */
    public String toStringGuts() {
        return Arrays.toString(elementData);
    }
}