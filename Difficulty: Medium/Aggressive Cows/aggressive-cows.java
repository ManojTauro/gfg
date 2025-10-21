class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        int l = 1;
        int h = Arrays.stream(stalls).max().getAsInt() - Arrays.stream(stalls).min().getAsInt();
        
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (canPlaceCows(stalls, k, m)) {
                l = m + 1;
            } else h = m - 1;
        }
        
        return h;
    }
    
    private boolean canPlaceCows(int[] stalls, int k, int minDis) {
        int curCows = 1;
        int lastPlace = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlace >= minDis) {
                curCows += 1;
                lastPlace = stalls[i];
            }
        }
        
        if (curCows >= k) return true;
        
        return false;
    }
}