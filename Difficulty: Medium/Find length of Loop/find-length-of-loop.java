/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == slow) break;
        }
        
        if (fast == null || fast.next == null) return 0;
        
        Node loopStartingPoint = slow;
        slow = slow.next;
        int count = 1;
        
        while (slow != loopStartingPoint) {
            slow = slow.next;
            count++;
        }
        
        return count;
    }
}