/*
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
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
        // code here
        int counter = 0;
        Node cur = head;
        
        while (counter != p) {
            cur = cur.next;
            counter++;
        }
        
        Node newNode = new Node(x);
        Node temp = cur.next;
        
        cur.next = newNode;
        newNode.prev = cur;
        
        if (temp != null) {
            temp.prev = newNode;
            newNode.next = temp;
        }
        
        return head;
    }
}