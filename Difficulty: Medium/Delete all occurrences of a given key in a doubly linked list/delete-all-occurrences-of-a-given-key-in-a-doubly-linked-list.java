// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node cur = head;
        
        while (cur != null && cur.data == x) {
            cur = cur.next;
            cur.prev = null;
            head = cur;
        }
        
        while (cur != null) {
            if (cur.data != x) {
                cur = cur.next ;
                continue;
            }
            
            // tail
            if (cur.next == null) {
                cur.prev.next = null;
                cur.prev = null;
                cur = cur.next;
                continue;
            }
            
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            
            cur = cur.next;
        }
        
        return head;
    }
}