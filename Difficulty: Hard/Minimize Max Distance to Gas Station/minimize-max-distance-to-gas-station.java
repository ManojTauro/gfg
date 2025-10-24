class Pair {
    double sectionLength;
    int sectionIndex;
    
    Pair(double sl, int si) {
        this.sectionLength = sl;
        this.sectionIndex = si;
    }
}

class Solution {
    public double minMaxDist(int[] stations, int K) {
        // return bf(stations, K);
        return optimized(stations, K);
    }
    
    private double optimized(int[] arr, int K) {
        int n = arr.length;
        
        if (n < 2) return 0.0;
        
        int[] sections = new int[n - 1];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Double.compare(p2.sectionLength, p1.sectionLength));
        
        for (int i = 0; i < n - 1; i++) {
            maxHeap.add(new Pair(arr[i + 1] - arr[i], i));
        }
        
        for (int gasStation = 1; gasStation <= K; gasStation++) {
            Pair p = maxHeap.poll();
            int secIndex = p.sectionIndex;
            
            sections[secIndex]++;
            
            double initialDiff = arr[secIndex + 1] - arr[secIndex];
            double newSectionLen = initialDiff / (double) (1 + sections[secIndex]);
            
            maxHeap.add(new Pair(newSectionLen, secIndex));
        }
        
        return maxHeap.peek().sectionLength;
    }
    
    private double bf(int[] arr, int K) {
        int n = arr.length;
        
        if (n < 2) return 0.0;
        
        int[] sections = new int[n - 1];
        for (int gasStation = 1; gasStation <= K; gasStation++) {
            double maxSectionLen = -1;
            int maxSectionInd = 0;
            
            for (int i = 0; i < n - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                double curSectionLen = diff / (double) (1 + sections[i]);
                
                if (curSectionLen > maxSectionLen) {
                    maxSectionLen = curSectionLen;
                    maxSectionInd = i;
                }
            }
            
            sections[maxSectionInd]++;
        }
        
        double ans = 0.0;
        for (int i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            double curSectionLen = diff / (double) (1 + sections[i]);
                
            if (curSectionLen > ans) {
                ans = curSectionLen;
            }
        }
        
        return ans;
    }
}
