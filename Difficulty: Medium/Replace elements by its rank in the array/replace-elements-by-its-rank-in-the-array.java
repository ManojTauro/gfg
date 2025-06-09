// User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for (int i = 0; i < N; i++) {
            pq.add(new int[]{arr[i], i});
        }
        
        int rank = 0;
        int lastNum = Integer.MAX_VALUE;
        
        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            
            if (lastNum == Integer.MAX_VALUE || lastNum != entry[0])
                rank++;
                
            arr[entry[1]] = rank;
            lastNum = entry[0];
        }
        
        return arr;
        
    }
}
