/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node suc = null;
        Node pre = null;
        
        Node cur = root;
        
        while (cur != null) {
            if (cur.data > key) {
                suc = cur;
                cur = cur.left;
            } else cur = cur.right;
        }
        
        cur = root;
        while (cur != null) {
            if (cur.data < key) {
                pre = cur;
                cur = cur.right;
            } else cur = cur.left;
        }
        
        return new ArrayList<>(Arrays.asList(pre, suc));
    }
}