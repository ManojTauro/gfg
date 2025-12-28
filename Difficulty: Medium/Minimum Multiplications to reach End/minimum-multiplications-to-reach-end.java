

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
