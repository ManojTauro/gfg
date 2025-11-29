/*
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        Node cur = head;
        
        while (cur != null && cur.next != null) {
            Node next = cur.next;
            
            while (next != null && next.data == cur.data) {
                next = next.next;
            }

            cur.next = next;
            
            if (next == null) {
                break;
            }
            
            next.prev = cur;
            
            cur = cur.next;
        }
        
        return head;
    }
}