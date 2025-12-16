/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (root == null) return ans;
        
        if (!isLeafNode(root)) ans.add(root.data);
        
        addLeftBoundary(root.left, ans);
        
        addLeaves(root, ans);
        
        addRightBoundary(root.right, ans);
        
        return ans;
    }
    
    private void addLeaves(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        
        if ((isLeafNode(root))) {
            ans.add(root.data);
            return;
        }
        
        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }
    
    private void addRightBoundary(Node root, ArrayList<Integer> ans) {
        LinkedList<Integer> rightBoundary = new LinkedList<>();
        while (root != null) {
            if (!isLeafNode(root)) rightBoundary.addFirst(root.data);
            
            root = root.right != null ? root.right : root.left;
        }
        
        ans.addAll(rightBoundary);
    }
    
    private void addLeftBoundary(Node root, ArrayList<Integer> ans) {
        while (root != null) {
            if (!isLeafNode(root)) ans.add(root.data);
            
            root = root.left != null ? root.left : root.right;
        }
    }
    
    private boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }
}