/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
        PriorityQueue<Node> minhp = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.data, n2.data));
        Node cur = root;
        
        while(cur != null) {
            minhp.offer(cur);
            cur = cur.next;
        }
        
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while (!minhp.isEmpty()) {
            Node node = minhp.poll();
            temp.bottom = node;
            temp = temp.bottom;
            
            if (node.bottom != null) {
                minhp.offer(node.bottom);
            }
        }
        
        return dummy.bottom;
    }
}