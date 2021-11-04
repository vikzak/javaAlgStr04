import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Node prev;
        T value;
        Node next;

        public Node(Node next) {
            this.next = next;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        private Node iterNode;

        public Iter() {
            this.iterNode = new Node(first);
        }

        @Override
        public boolean hasNext() {
            return iterNode.getNext() != null;
        }

        @Override
        public T next() {
            iterNode = iterNode.getNext();
            return iterNode.getValue();
        }
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    private class ListIter implements ListIterator<T> {
        private Node currentNode;
        private Node beforeFirstNode;
        private Node afterLastNode;
        private int currentIndex;

        public ListIter() {
            if (!isEmpty()) {
                this.beforeFirstNode = new Node((Node) null, first);
                this.afterLastNode = new Node(last, null);
                currentNode = beforeFirstNode;
                System.out.println("last: " + last.getValue());
                System.out.println("first: " + first.getValue());
            }
        }

        @Override
        public boolean hasNext() {
            return currentNode.getNext() != null && currentNode.getNext() != afterLastNode;
        }

        @Override
        public T next() {
            if (currentNode.getNext() == null) {
                if (currentNode == afterLastNode) {
                    return null;
                } else {
                    currentNode = afterLastNode;
                    return null;
                }
            }
            currentNode = currentNode.getNext();
            return currentNode.getValue();
        }

        @Override
        public boolean hasPrevious() {
            return currentNode.getPrev() != null && currentNode.getPrev() != beforeFirstNode;
        }

        @Override
        public T previous() {
            if (currentNode.getPrev() == beforeFirstNode) {
                currentNode = beforeFirstNode;
                return null;
            }
            if (currentNode.getPrev() == null) {
                if (currentNode == beforeFirstNode) {
                    return null;
                } else {
                    currentNode = beforeFirstNode;
                    return null;
                }
            }
            currentNode = currentNode.getPrev();
            return currentNode.getValue();
        }

        @Override
        public int nextIndex() {
            return -1;
        }

        @Override
        public int previousIndex() {
            return -1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    public final int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }


    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(last, item, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T deleteFirst() {
        T temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public T deleteLast() {
        T temp = getLast();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    public final T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Is empty");
        }
        return last.getValue();
    }

    public boolean delete(T item) {
        if (isEmpty()) {
            return false;
        }
        if (item.equals(first.getValue())) {
            deleteFirst();
            return true;
        }
        Node current = first;
        while (current != null && !item.equals(current.getValue())) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            deleteLast();
            return true;
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;
    }

    public final T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Is empty");
        }
        return first.getValue();
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }
        Node current = first;
        int i = 1;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(current, item, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }


    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            sb.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
