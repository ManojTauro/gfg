/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        int value = dfs(root);
        
        return value == root.data;
    }
    
    private int dfs(Node root) {
        if (root == null) return 0;
        
        if (root.left == null && root.right == null)
            return root.data;
        
        int leftVal = dfs(root.left);
        if (leftVal == -1) return -1;
        
        int rightVal = dfs(root.right);
        if (rightVal == -1) return -1;
        
        if (leftVal + rightVal != root.data) return -1;
        
        return root.data;
    }
}