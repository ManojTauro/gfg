// Node class
/* class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
} */

// Stack class
class myStack {
    Node head = null;
    int size = 0;
    
    public myStack() {
        // Initialize your data members
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int x) {
        Node n = new Node(x);
        
        if (head == null) head = n;
        else {
            n.next = head;
            head = n;
        }
        
        size++;
    }

    public void pop() {
        if (isEmpty()) return;
        
        head = head.next;
        
        size--;
    }

    public int peek() {
        if (isEmpty()) return -1;
        
        return head.data;
    }

    public int size() {
        return size;
    }
}
