/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), ans);
        
        return ans;
    }
    
    private static void dfs(Node root, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        if (root.left == null && root.right == null) {
            temp.add(root.data);
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(root.data);
        if (root.left != null) {
            dfs(root.left, temp, ans);
            temp.remove(temp.size() - 1);   
        }
    
        if (root.right != null) {
            dfs(root.right, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}