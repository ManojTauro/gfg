class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int len = stalls.length;
        
        int low = 0;
        int high = stalls[len - 1] - stalls[0]; // max distance possible
        
        while (low <= high) {
            int m = (low + high) / 2;
            
            if (canWePlaceCows(stalls, m, k)) low = m + 1;
            else high = m - 1;
        }
        
        return high;
    }
    
    private boolean canWePlaceCows(int[] arr, int dis, int k) {
        int placedCowsCount = 1;
        int lastPlacedCow = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlacedCow >= dis) {
                placedCowsCount++;
                lastPlacedCow = arr[i];
            }
        }
        
        if (placedCowsCount >= k) return true;
        
        return false;
    }
}