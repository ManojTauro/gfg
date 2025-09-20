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
        Node slow = head;
        Node fast = head;
        Node start = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return 0;
        
        Node meetingPoint = slow;
        slow = slow.next;
        int count = 1;
        
        while (slow != meetingPoint) {
            count++;
            slow = slow.next;
        }
        
        return count;
    }
}