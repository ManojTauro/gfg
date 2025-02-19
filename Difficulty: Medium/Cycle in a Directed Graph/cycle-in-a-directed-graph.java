//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pV = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, pV, adj)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(int node, boolean[] vis, boolean[] pVis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        pVis[node] = true;
        
        for (int adjNode: adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, vis, pVis, adj)) return true;
            } else if (pVis[adjNode]) return true;
        }
        
        
        pVis[node] = false;
        return false;
    }
}