// Flexible size. Last in first out (LIFO)

public class Stack {
    private static class Node {
        private int data;
        private Node next;
        private Node (int data) {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        return top.data;
    }

    public void push(int data) {
        Node newTop = new Node(data);
        newTop.next = top;
    }

    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }

    public static class MyQueue {
        private Stack enqueueStack = new Stack();
        private Stack dequeueStack = new Stack();
    
        public void enqueue(int data) {
            enqueueStack.push(data);
        }
    
        public int dequeue() {
            if (dequeueStack.isEmpty()) {
                while (!enqueueStack.isEmpty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
            }
            return dequeueStack.pop();
        }
    
        public boolean isEmpty() {
            return enqueueStack.isEmpty() && dequeueStack.isEmpty();
        }
    }

}
