// User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < n; i++)
            adj.put(i, new HashSet<>());
            
        for (ArrayList<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            
            if (u == v) return false;
            
            if (adj.get(u).contains(v)) return false;
            
            if (adj.get(v).contains(u)) return false;
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n];
        
        // check cycle
        if (dfs(0, -1, vis, adj)) return false;
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;
        }
        
        return true;
        
    }
    
    private boolean dfs(int node, int parentNode, boolean[] vis, Map<Integer, Set<Integer>> adj) {
        vis[node] = true;
        
        for (int adjNode: adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, node, vis, adj)) return false;
            } else if (adjNode != parentNode) return true;
        }
        
        return false;
    }
}
