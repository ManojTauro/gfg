class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double ans = 0;
        int len = val.length;
        List<Pair> sortedPair = new ArrayList<>();
        
        // create a sorted array according to value per weight
        // i.e 60/10 = 6 and 120/30 = 4
        for (int i = 0; i < len; i++) {
            Pair p = new Pair(val[i], wt[i]);
            sortedPair.add(p);
        }
        
        Comparator<Pair> cmp = (
            (p1, p2) -> Double.compare((double) p2.val / p2.wt, (double) p1.val / p1.wt)
        );
        Collections.sort(sortedPair, cmp);
        
        int j = 0;
        while (capacity != 0 && j < sortedPair.size()) {
            Pair p = sortedPair.get(j);
            if (p.wt <= capacity) {
                ans += p.val;
                capacity -= p.wt;
            } else {
                int v = p.val;
                int w = p.wt;
                
                double ratio = (double) p.val / (double) p.wt;
                ans += ratio * capacity;
                capacity = 0;
            }
            j++;
        }
        
        return ans;
            
    }
    
    record Pair(int val, int wt){}
    
}