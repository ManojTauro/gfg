/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        Node zeroDum = new Node(-1);
        Node zeroCur = zeroDum;
        
        Node oneDum = new Node(-1);
        Node oneCur = oneDum;
        
        Node twoDum = new Node(-1);
        Node twoCur = twoDum;
        
        while (head != null) {
            int val = head.data;
            
            if (val == 0) {
                zeroCur.next = head;
                zeroCur = zeroCur.next;
            } else if (val == 1) {
                oneCur.next = head;
                oneCur = oneCur.next;
            } else {
                twoCur.next = head;
                twoCur = twoCur.next;
            }
            
            head = head.next;
        }
        
        zeroCur.next = null;
        oneCur.next = null;
        twoCur.next = null;
        
        // Connect: zeros → ones → twos
        if (oneDum.next != null) {
            zeroCur.next = oneDum.next;
            oneCur.next = twoDum.next;
        } else {
            zeroCur.next = twoDum.next;
        }
        
        return zeroDum.next;
        
    }
}