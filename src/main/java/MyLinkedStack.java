public class MyLinkedStack<T> {
    private MyLinkedList<T> list;

    public MyLinkedStack() {
        this.list = new MyLinkedList<>();
    }

    public void push(T item) {
        list.insertFirst(item);
    }

    public T peek() {
        return list.getFirst();
    }

    public T pop() {
        return list.deleteFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
