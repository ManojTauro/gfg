class Solution {
    private void fillAdj(ArrayList<ArrayList<Integer>> adj, int[][] edges) {
        
        for (int edge[]: edges) {
            adj.get(edge[0]).add(edge[1]);
        }
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        fillAdj(adj, edges);
        
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < V; i++)
            for (int j = 0; j < adj.get(i).size(); j++)
                indegree[adj.get(i).get(j)]++;
                
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for (int adjNode: adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        
        return ans.size() != V;
    }
}