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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size-1; i++) {
            s.append(getNode(i));
            s.append(" ");
        }
        s.append(getNode(size - 1));
        return s.toString();
    }
}
