package stage2.mylists;

import java.util.Collection;
import java.util.Objects;

/**
 * Tutorial class with a simple LinkedList implementation
 *
 * @author Denis Nikulin
 */
public class MyLinkedList<E extends Comparable<E>> {
    /**
     * The size of the LinkedList.
     */
    private int size = 0;
    /**
     * Pointer to first node.
     */
    private Node<E> first;
    /**
     * Pointer to last node.
     */
    private Node<E> last;

    /**
     * Cornerstone of the LinkedList.
     * Pointers on prev and next Nodes and current element combination
     */
    private static class Node<E> {
        Node<E> next;
        Node<E> prev;
        E e;

        Node(Node<E> prev, E element, Node<E> next) {
            this.e = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
    }

    /**
     * get the Node by index
     *
     * @param index index of the needed Node
     * @return Node<E>
     */
    private Node<E> getNode(int index) {
        Objects.checkIndex(index, size);
        Node<E> curr;
        if (index < (size >> 1)) {
            curr = first;
            for (int i = 0; i < index; i++)
                curr = curr.next;
        } else {
            curr = last;
            for (int i = size - 1; i > index; i--)
                curr = curr.prev;
        }
        return curr;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public boolean add(E e) {
        if (size == 0) {
            first = new Node<>(null, e, null);
            last = first;
            size++;
            return true;
        }
        Node<E> newNode = new Node<>(getNode(size - 1), e, null);
        getNode(size - 1).next = newNode;
        last = newNode;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param e     element to be inserted
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public void add(int index, E e) {
        Objects.checkIndex(index, size + 1);
        if (size == 0 || index == size) {
            this.add(e);
            return;
        }
        if (index == 0) {
            Node<E> newNode = new Node<>(null, e, getNode(index));
            getNode(index).prev = newNode;
            first = newNode;
            size++;
            return;
        }
        Node<E> newNode = new Node<>(getNode(index - 1), e, getNode(index));
        getNode(index).prev = newNode;
        getNode(index - 1).next = newNode;
        size++;
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
        return getNode(index).e;
    }

    /**
     * Removes the element at the specified position in this list.
     * remove is dirty, just cleaning links
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public E remove(int index) {
        Objects.checkIndex(index, size);
        E oldValue = get(index);
        if (index == 0) {
            first.next.prev = null;
            first = first.next;
            size--;
            return oldValue;
        }
        if (index == size - 1) {
            last.prev.next = null;
            last = last.prev;
            size--;
            return oldValue;
        }
        Node<E> nodePrev = getNode(index - 1);
        Node<E> nodeNext = getNode(index + 1);
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        size--;

        return oldValue;
    }

    /**
     * Removes all of the elements from this list.
     * remove is dirty, just cleaning links
     */
    public void clear() {
        this.size = 0;
        first = null;
        last = null;
    }

    /**
     * Sorts the array using the QuickSort algorithm.
     */
    public void sort() {
        quicksort(0, size - 1);
    }

    private void quicksort(int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(low, high);
        quicksort(low, pivot - 1);
        quicksort(pivot + 1, high);
    }

    private int partition(int low, int high) {
        int pivotIndex = (low + high) / 2;
        swap(pivotIndex, high);
        int pivotIndexCounter = low;
        for (int i = low; i < high; i++) {
            if (this.get(i).compareTo(this.get(high)) <= 0) swap(pivotIndexCounter++, i);
        }
        swap(pivotIndexCounter, high);
        return pivotIndexCounter;
    }

    private void swap(int firstIndex, int secondIndex) {
        if (firstIndex != secondIndex) {
            E temp = this.get(firstIndex);
            this.set(firstIndex, this.get(secondIndex));
            this.set(secondIndex, temp);
        }
    }

    public void set(int index, E e) {
        Objects.checkIndex(index, size);
        getNode(index).e = e;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size - 1; i++) {
            s.append(getNode(i));
            s.append(" ");
        }
        s.append(getNode(size - 1));
        s.append("]");
        return s.toString();
    }
}
