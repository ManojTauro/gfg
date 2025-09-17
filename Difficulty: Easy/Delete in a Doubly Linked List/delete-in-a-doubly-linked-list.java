/*
Structure of a Doubly LinkList
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node delPos(Node head, int x) {
        Node cur = head;
        int counter = 1;
        
        while (counter != x) {
            counter++;
            cur = cur.next;
        }
        
        //head
        if (cur.prev == null) {
            cur.next.prev = null;
            head = cur.next;
            return head;
        }
        
        // tail
        if (cur.next == null) {
            cur.prev.next = null;
            cur.prev = null;
            return head;
        }
        
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        return head;
    }
}