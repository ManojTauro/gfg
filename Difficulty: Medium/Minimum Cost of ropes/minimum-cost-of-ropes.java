class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> minhp = new PriorityQueue<>();
        
        for (int num: arr) minhp.add(num);
        
        int minCost = 0;
        while (minhp.size() >= 2) {
            int r1 = minhp.poll();
            int r2 = minhp.poll();
            int newLen = r1 + r2;
            
            minCost+= newLen;
            
            minhp.add(newLen);
        }
        
        return minCost;
    }
}