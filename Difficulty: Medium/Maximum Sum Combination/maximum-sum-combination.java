class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        int n = a.length;
        // pq will hold (sum, i, j)
        PriorityQueue<int[]> maxhp = new PriorityQueue<>((a1, a2) -> Integer.compare(a2[0], a1[0]));
        ArrayList<Integer> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        
        // sort in ascending order
        Arrays.sort(a);
        Arrays.sort(b);
        
        // add sum of last elements from a and b because those are largest
        maxhp.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        visited.add(new String((n - 1) + ","+(n - 1)));
        
        while (k > 0 && !maxhp.isEmpty()) {
            int[] entry = maxhp.poll();
            int i = entry[1];
            int j = entry[2];
            
            res.add(entry[0]);
            
            String key = "";
            if (i - 1 >= 0) {
                key = (i - 1) + "," + j;
                
                if (!visited.contains(key)) {
                    maxhp.offer(new int[]{a[i - 1] + b[j], i - 1, j});
                    visited.add(key);
                }
            }
            
            if (j - 1 >= 0) {
                key = i + "," + (j - 1);
                
                if (!visited.contains(key)) {
                    maxhp.offer(new int[]{a[i] + b[j - 1], i, j - 1});
                    visited.add(key);
                }
            }
            
            k--;
        }
        
        return res;
    }
    
    // brute force
    public ArrayList<Integer> topKSumPairsBF(int[] a, int[] b, int k) {
        // code here
        PriorityQueue<Integer> minhp = new PriorityQueue<>();
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int sum = a[i] + b[j];
                
                minhp.offer(sum);
            
                if (minhp.size() > k) minhp.poll();
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while (!minhp.isEmpty())  res.add(minhp.poll());
        
        Collections.reverse(res);
        
        return res;
    }
}