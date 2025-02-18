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
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<int[]> pq = new LinkedList<>(); 
        int[] dis = new int[100000];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        pq.add(new int[]{0, start});
        int MOD = 100000;
        
        if (start == end) return 0;
        
        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            int node = entry[1];
            int steps = entry[0];
            
            for (int num: arr) {
                int nextNode = (node * num) % MOD; // next node
                if (steps + 1 < dis[nextNode]) {
                    dis[nextNode] = steps + 1;
                    
                    if (nextNode == end) return steps + 1;
                    
                    pq.offer(new int[]{steps + 1, nextNode});
                }
                
            }
        }
        
        return -1;
    }
}
