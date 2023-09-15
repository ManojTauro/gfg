//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<>());
            
        for(int i=0; i<m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        int[] dis = new int[n+1];

        int[] parent = new int[n+1];
        
        for(int i = 1;i<=n;i++) {
            dis[i] = Integer.MAX_VALUE; 
            parent[i] = i; 
        }
        
        dis[1] = 0;
        pq.add(new Pair(1,0));
        
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.toEdge;
            int d = p.dis;
            
            for(Pair neighbor: adj.get(node)) {
                int nNode = neighbor.toEdge;
                int nDis = neighbor.dis;
                
                if(d + nDis < dis[nNode]) {
                    dis[nNode] = d + nDis;
                    pq.add(new Pair(nNode, dis[nNode]));
                    parent[nNode] = node;
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if(dis[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }
        
        int node = n;
        
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        
        path.add(1);
        
        Collections.reverse(path);
        
        return path;
    }
}

class Pair {
    int toEdge;
    int dis;
    
    Pair(int toEdge, int dis) {
        this.toEdge = toEdge;
        this.dis = dis;
    }
}