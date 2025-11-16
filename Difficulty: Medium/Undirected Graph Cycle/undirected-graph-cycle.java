class Solution {
    // using DFS
    public boolean isCycle(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = getAdjList(v, edges);
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adjList) == true) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adjList) {
        vis[node] = true;
        
        for (int adjNode: adjList.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, node, vis, adjList)) return true;
            } else {
                if (adjNode != parent) return true;
            }
        }
        
        return false;
    }
    
    private ArrayList<ArrayList<Integer>> getAdjList(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < v; i++) adjList.add(new ArrayList<>());
        
        for (int[] edge: edges) {
            int src = edge[0];
            int dest = edge[1];
            
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        
        
        return adjList;
    }
}