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
     * The size of the ArrayList (how it looks outside).
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
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public void add(int index, E e) {
        Objects.checkIndex(index, size);
        if (elementData.length == size) {
            elementData = Arrays.copyOf(elementData, size + 5);
        }
        System.arraycopy(elementData, index,
                elementData, index + 1,
                size++ - index);
        elementData[index] = e;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     * @see <a href="http://www.angelikalanger.com/GenericsFAQ/FAQSections/TechnicalDetails.html#FAQ001">What is an "unchecked" warning</a>
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
     * @param index the index of the element
     * @return the element of the param index
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    /**
     * @see <a href="http://www.angelikalanger.com/GenericsFAQ/FAQSections/TechnicalDetails.html#FAQ001">What is an "unchecked" warning</a>
     */
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
     * Removes all of the elements from this list.  The list will
     * be empty with inside array of length 5.
     */
    public void clear() {
        this.size = 0;
        elementData = new Object[5];
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