class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        fillAdj(adj, edges);
        
        boolean[] vis = new boolean[V];
        Deque<Integer> st = new ArrayDeque<>();
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        
        return ans;
    }
    
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Deque<Integer> st) {
        vis[node] = true;
        
        for (int adjNode: adj.get(node)) {
            if (!vis[adjNode])
                dfs(adjNode, vis, adj, st);
        }
        
        st.push(node);
    }
    
    private void fillAdj(ArrayList<ArrayList<Integer>> adj, int[][] edges) {
        
        for (int edge[]: edges) {
            adj.get(edge[0]).add(edge[1]);
        }
    }
}