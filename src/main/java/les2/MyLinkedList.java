package les2;

public class MyLinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;


    public void add(E value) {
        if (first == null) {
            first = new Node<>(value, null, null);
        } else {
            Node<E> newNode = new Node<>(value, null, last);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void add(int index, E value) {
        Node<E> newNode = new Node<>(value, null, null);

        Node<E> node = getNodeByIndex(index);
        if (node != null) {
            Node<E> prev = node.prev;
            prev.next = newNode;
            node.prev = newNode;
            newNode.next = node;
            newNode.prev = prev;
            size++;
        }

    }

    private Node<E> getNodeByIndex(int index) {
        int tmpIndex = 0;

        if (first == null) {
            return null;
        }

        if (index == 0) {
            return first;
        }

        Node<E> node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        return null;
    }

    public boolean remove(int index) {
        Node<E> node = getNodeByIndex(index);
        if (node != null) {
            Node<E> prev = node.prev;
            Node<E> next = node.next;

            prev.next = next;
            next.prev = prev;
            size--;
            return true;
        }
        return false;
    }

    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node == null ? null : node.value;
    }

    private class Node<T> {
        private final T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
