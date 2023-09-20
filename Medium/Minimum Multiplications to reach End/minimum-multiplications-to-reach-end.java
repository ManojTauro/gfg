//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        Queue<Pair> q = new LinkedList<>();
        int[] dis = new int[100000];
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        q.add(new Pair(0, start));
        dis[start] = 0;
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int steps = p.steps;
            int node = p.node;
            
            
            for(int i=0; i<arr.length; i++) {
                int nextNode = (node * arr[i]) % 100000;
                
                if(steps + 1 < dis[nextNode]) {
                    dis[nextNode] = steps + 1;
                    
                    if(nextNode == end) return steps + 1;
                    
                    q.add(new Pair(steps + 1, nextNode));
                }
            }
        }
        
        return -1;
    }
}

class Pair {
    int steps;
    int node;
    
    Pair(int steps, int node) {
        this.steps = steps;
        this.node = node;
    }
}
