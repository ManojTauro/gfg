// User function Template for Java
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        Comparator<int[]> cmp = (e1, e2) -> Integer.compare(e1[2], e2[2]);
        Arrays.sort(edges, cmp);
        DisjointSet ds = new DisjointSet(V);
        int ans = 0;
        
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if (ds.findUltPar(u) != ds.findUltPar(v)) {
                ans += wt;
                ds.unionBySize(u, v);
            }
            
        }
        
        return ans;
    }
}

class DisjointSet {
    int[] parent, size;
    
    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        
        for (int i = 0; i <= n; i++) parent[i] = i;
        
        Arrays.fill(size, 1);
    }
    
    public int findUltPar(int node) {
        if (node == parent[node]) return node;
        
        int parentNode = findUltPar(parent[node]);
        parent[node] = parentNode;
        
        return parentNode;
    }
    
    public void unionBySize(int u, int v) {
        int ulpU = findUltPar(u);
        int ulpV = findUltPar(v);
        
        if (ulpU == ulpV) return;
        
        if (size[ulpU] < size[ulpV]) {
            parent[ulpU] = ulpV;
            size[ulpV] = size[ulpV] + size[ulpU];
        } else {
            parent[ulpV] = ulpU;
            size[ulpU] = size[ulpV] + size[ulpU];
        }
    }
}
