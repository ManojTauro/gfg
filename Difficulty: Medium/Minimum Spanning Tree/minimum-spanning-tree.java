class Solution {
    record State(int wt, int node, int parent) {}
    
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        PriorityQueue<State> pq = new PriorityQueue<>(
            (s1, s2) -> Integer.compare(s1.wt, s2.wt)    
        );
        boolean[] vis = new boolean[V];
        
        pq.offer(new State(0, 0, -1));
        int ans = 0;
        
        while (!pq.isEmpty()) {
            State s = pq.poll();
            
            if (vis[s.node]) continue;
            
            vis[s.node] = true;
            ans += s.wt;
            
            for (int[] adjNode: graph.get(s.node)) {
                int next = adjNode[0];
                int wt = adjNode[1];
                
                pq.offer(new State(wt, next, s.node));
            }
        }
        
        return ans;
    }
}
