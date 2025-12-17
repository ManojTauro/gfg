/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    record Pair(Node node, int vertical){}
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        // Map of Vertical, Top Node
        Map<Integer, Integer> map = new TreeMap<>();
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int vertical = p.vertical;
            
            map.putIfAbsent(vertical, node.data);
            
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