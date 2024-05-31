

public class LinkedListStack<E> implements Stack<E> {

	// node (class) of the linked list
    private static class Node<E> {
    	
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return ((next == null) ? "" : next.toString() + "-") + data.toString();
        }
    }

    private Node<E> top;

    public LinkedListStack() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E top() throws Underflow {
        if (isEmpty()) {
            throw new Underflow();
        }
        return top.data;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public E pop() throws Underflow {
        if (isEmpty()) {
            throw new Underflow();
        }
        E data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public String toString() {
        if (top == null)
            return "<empty>";
        return "<stack: " + top.toString() + ">";
    }
}
