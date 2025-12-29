// User function Template for Java

class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        int V = rows * cols;
        DisjointSet ds = new DisjointSet(V);
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int[][] vis = new int[rows][cols];
        
        for (int[] op: operators) {
            int i = op[0];
            int j = op[1];
            int node = (cols * i) + j;
            
            if (vis[i][j] == 1) {
                ans.add(count);
                continue;
            }
            
            vis[i][j] = 1;
            count += 1;
            
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir: dirs) {
                int ni = dir[0] + i;
                int nj = dir[1] + j;
                int adjNode = (cols * ni) + nj;
                
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    if (vis[ni][nj] == 1) {
                        if (ds.findUltimateParent(node) != ds.findUltimateParent(adjNode)) {
                            ds.unionBySize(node, adjNode);
                            count--;
                        }
                    }
                }
            }
            
            ans.add(count);
            
        }
        
        return ans;
        
    }
}

class DisjointSet {
    private List<Integer> rank = new ArrayList<>();
    private List<Integer> parent = new ArrayList<>();
    
    //Not mandatory - we can do it either by rank or size
    private List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int V) {
        for(int i=0; i<V; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public List<Integer> getParent() {
        return parent;
    }
    
    public int findUltimateParent(int node) {
        if(node == parent.get(node)) return node;
        
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        
        return parent.get(node);
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}