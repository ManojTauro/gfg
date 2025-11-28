/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        int carry = helper(head);
        
        if (carry == 1) {
            Node node = new Node(1);
            node.next = head;
            return node;
        }
        
        return head;
    }
    
    private int helper(Node node) {
        if (node == null) return 1;
        
        int carry = helper(node.next);
        
        node.data = node.data + carry;
        
        if (node.data < 10) return 0;
        
        node.data = 0;
        
        return 1;
    }
}