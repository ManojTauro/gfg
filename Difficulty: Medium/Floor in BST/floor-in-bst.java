/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int x) {
        // code here
        int ans = -1; // fllow
        
        while (root != null) {
            if (root.data > x) {
                root = root.left;
            } else {
                ans = root.data;
                root = root.right;
            }
        }
        
        return ans;
    }
}