import java.util.ListIterator;

public class Lesson4 {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();
        mll.insertFirst(6);
        mll.insertFirst(5);
        mll.insertFirst(3);
        mll.insertFirst(4);
        mll.insertFirst(2);

        System.out.println(mll);
        mll.insert(0, 78);
        System.out.println(mll);
        mll.insert(3, 45);
        System.out.println(mll);
        mll.insert(7, 34);
        System.out.println(mll);
        mll.delete(56);
        System.out.println(mll);
        mll.delete(98);
        System.out.println(mll);
        mll.delete(89);
        System.out.println(mll);
        mll.delete(99);
        System.out.println(mll);
        mll.insertLast(66);
        mll.insertLast(99);

        //MyLinkedStack
        System.out.println("\nMyLinkedStack:");
        MyLinkedStack<Integer> linkedStack = new MyLinkedStack<>();
        System.out.println(linkedStack);
        linkedStack.push(5);
        linkedStack.push(6);
        linkedStack.push(4);
        linkedStack.push(3);
        linkedStack.push(2);
        System.out.println(linkedStack);
        System.out.println(linkedStack.peek());
        System.out.println(linkedStack);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack);
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack);

        //ListIterator
        System.out.println("\nListIterator:");
        System.out.println(mll);
        ListIterator<Integer> listIterator = mll.listIterator();
        System.out.println(listIterator.hasNext());
        System.out.println("nextIndex: " + listIterator.nextIndex());
        System.out.println(listIterator.next());
        System.out.println("nextIndex: " + listIterator.nextIndex());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println("nextIndex: " + listIterator.nextIndex());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println("nextIndex: " + listIterator.nextIndex());
        System.out.println("\n");
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println("prevIndex: " + listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println("prevIndex: " + listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println("prevIndex: " + listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println("prevIndex: " + listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.previous());
        System.out.println("prevIndex: " + listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
        System.out.println(listIterator.next());
    }
}
