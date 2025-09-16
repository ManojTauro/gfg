/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        f(root, ans, 0);
        
        return ans;
    }
    
    private void f(Node root, ArrayList<Integer> ans, int l) {
        if (root == null) return;
        
        if (l == ans.size()) ans.add(root.data);
        
        f(root.left, ans, l + 1);
        f(root.right, ans, l + 1);
    }
}