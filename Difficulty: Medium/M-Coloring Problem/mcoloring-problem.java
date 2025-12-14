

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        int n = edges.length;
        int[] color = new int[v];
        List<List<Integer>> edgeList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            edgeList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        
        if (solve(0, edgeList, color, v, m) == true) return true;
        
        return false;
    }
    
    private static boolean isSafe(int node, List<List<Integer>> G, int[] color, int col) {
        for (int it: G.get(node)) {
            if (color[it] == col) return false;
        }
        return true;
    }
    
    private static boolean solve(int node, List<List<Integer>> G, int[] color, int n, int m) {
        if (node == n) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, G, color, c)) {
                color[node] = c;
                if (solve(node + 1, G, color, n, m) == true) return true;
                color[node] = 0;
            }
        }
        return false;
    }
}