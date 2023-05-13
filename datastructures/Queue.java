package CS2040.datastructures;

// Flexible size. First in first out (FIFO)

public class Queue {
    private static class Node {
        private int data;
        private Node next;
        private Node (int data){
            this.data = data;
        }
    }

    private Node head; //remove from here
    private Node tail; //add to here

    public boolean isEmpty () {
        return head==null;
    }

    public int peek() {
        return head.data;
    }

    public void add (int data) {
        Node newTail = new Node(data);
        if (tail != null) {
            tail.next = newTail;
        }
        tail = newTail;
        if (head == null) {
            head = newTail;
        }
    }

    public int remove () { //and return data if the one removed
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}
