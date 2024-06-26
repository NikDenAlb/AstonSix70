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
            getNode(index).next = newNode;
            first = newNode;
            size++;
            return;
        }
        Node<E> newNode = new Node<>(getNode(index - 1), e, getNode(index));
        getNode(index - 1).next = newNode;
        getNode(index).prev = newNode;
        size++;
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
