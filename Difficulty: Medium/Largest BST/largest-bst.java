// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    record Info(int size, int min, int max, boolean isBST) {}
    
    static int largestBst(Node root) {
        Info ans = f(root);
        return ans.size;
    }
    
    static private Info f(Node root) {
        // Null node is considered a valid BST
        if (root == null) 
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        
        Info left = f(root.left);
        Info right = f(root.right);
        
        // Check if current tree is a valid BST
        // Both subtrees must be BSTs AND satisfy BST property
        if (left.isBST && right.isBST && left.max < root.data && root.data < right.min) {
            int size = 1 + left.size + right.size;
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);
            return new Info(size, min, max, true);
        } else {
            // Not a BST: return the larger BST found in subtrees
            int size = Math.max(left.size, right.size);
            return new Info(size, 0, 0, false);
        }
    }
}