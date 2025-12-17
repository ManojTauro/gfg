/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    record Pair(Node node, int vertical){}
    
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer, Integer> map = new TreeMap<>();
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int vertical = p.vertical;
            
            map.put(vertical, node.data);
            
            if (node.left != null)
                q.offer(new Pair(node.left, vertical - 1));
                
            if (node.right != null)
                q.offer(new Pair(node.right, vertical + 1));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(map.values());
        
        return ans;
    }
}