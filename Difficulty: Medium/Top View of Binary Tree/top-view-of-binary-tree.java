/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int v = p.vertical;
            
            map.putIfAbsent(v, node.data);
            
            if (node.left != null) {
                q.add(new Pair(node.left, v - 1));
            }
            
            if (node.right != null) {
                q.add(new Pair(node.right, v + 1));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int v: map.values()) {
            ans.add(v);
        }
        
        return ans;
    }
}

class Pair {
    Node node;
    int vertical;
    
    Pair(Node v, int ver) {
        this.node = v;
        this.vertical = ver;
    }
}