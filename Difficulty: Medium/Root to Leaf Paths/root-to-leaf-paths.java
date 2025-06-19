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
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        f(root, temp, res);
        
        return res;
    }
    
    private static void f(Node root,  ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        temp.add(root.data);
        
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        
        if (root.left != null) {
            f(root.left, temp, res);
        }
        
        if (root.right != null) {
            f(root.right, temp, res);
        }
        
        temp.remove(temp.size() - 1);
    }
}