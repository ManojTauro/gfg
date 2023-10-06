//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

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
    
    public void unionByRank(int src, int dest) {
        int ulp_src = findUltimateParent(src);
        int ulp_dest = findUltimateParent(dest);
        
        if(ulp_src == ulp_dest) return; // Src and Dest is in the same component
        
        if(rank.get(ulp_src) < rank.get(ulp_dest))
            parent.set(ulp_src, ulp_dest);
        
        else if(rank.get(ulp_src) > rank.get(ulp_dest))
            parent.set(ulp_dest, ulp_src);
            
        else {
            parent.set(ulp_src, ulp_dest);
            int rankSrc = rank.get(ulp_src);
            rank.set(ulp_src, rankSrc + 1);
        }
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

class Solution {
    
    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows * cols);
        boolean[][] vis = new boolean[rows][cols];
        int count = 0;
        int len = operators.length;
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<len; i++) {
            int r = operators[i][0];
            int c = operators[i][1];
            
            if(vis[r][c]) {
                ans.add(count);
                continue;
            }
            
            vis[r][c] = true;
            count++;
            
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            
            for(int[] dir: dirs) {
                int adjr = r + dir[0];
                int adjc = c + dir[1];
                
                if(isValid(adjr, adjc, rows, cols)) {
                    if(vis[adjr][adjc]) {
                        int node = r * cols + c;
                        int adjNode = adjr * cols + adjc;
                        if(ds.findUltimateParent(node) != ds.findUltimateParent(adjNode)) {
                            count--;
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
            ans.add(count);
        }
        
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends