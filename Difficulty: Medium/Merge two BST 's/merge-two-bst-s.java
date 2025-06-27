/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    
    public ArrayList<Integer> merge(Node root1, Node root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        inorder(root1, arr1);
        inorder(root2, arr2);
        int i = 0;
        int j = 0;
        
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                ans.add(arr1.get(i));
                i++;
            } else {
                ans.add(arr2.get(j));
                j++;
            }   
        }
        
        while (i < arr1.size()) ans.add(arr1.get(i++));
        while (j < arr2.size()) ans.add(arr2.get(j++));
        
        return ans;
    }
    
    private void inorder(Node root, List<Integer> arr) {
        if (root == null) return;
        
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
}