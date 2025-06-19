/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Check if the tree is empty
        if(root == null) {
            return ans;
        }
        
        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();
        
        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue<Pair> q = new LinkedList<>();
        
        // Push the root node with its vertical
        // position (0) into the queue
        q.add(new Pair(root, 0));
        
        // BFS traversal
        while(!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair pair = q.poll();
            Node node = pair.node;
            int line = pair.vertical;
            
            // Update the map with the node's data
            // for the current vertical position
            mpp.put(line, node.data);
            
            // Process left child
            if(node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair(node.left, line - 1));
            }
            
            // Process right child
            if(node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair(node.right, line + 1));
            }
        }
        
        // Transfer values from the
        // map to the result list
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
        
    }
}

class Pair {
    Node node;
    int vertical;
    
    Pair(Node n, int v) {
        this.node = n;
        this.vertical = v;
    }
}