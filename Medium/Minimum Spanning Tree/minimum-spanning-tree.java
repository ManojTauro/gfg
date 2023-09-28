//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    List<Edge> edgeList = new ArrayList<>();
	    
	    for(int i=0; i<E; i++) {
	        int src = edges[i][0];
	        int dest = edges[i][1];
	        int weight = edges[i][2];
	        
	        edgeList.add(new Edge(src, dest, weight));
	    }
	    
	    Collections.sort(edgeList);
	    
	    DisjointSet ds = new DisjointSet(V);
	    int mstWeight = 0;
	    
	    for(int i=0; i<edgeList.size(); i++) {
	        int src = edgeList.get(i).src;    
	        int dest = edgeList.get(i).dest;
	        int weight = edgeList.get(i).weight;
	        
	        if(ds.findUltimateParent(src) != ds.findUltimateParent(dest)) {
	            mstWeight += weight;
	            ds.unionByRank(src, dest);
	        }
	    }
	    
	    return mstWeight;
	}
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    
    Edge(int _src, int _dest, int _weight) {
        this.src = _src; this.dest = _dest; this.weight = _weight;
    }
    
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
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