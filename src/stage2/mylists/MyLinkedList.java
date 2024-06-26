package stage2.mylists;

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
    }
}
