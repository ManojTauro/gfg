class Solution {
    public int minTime(int[] arr, int k) {
        int h = Arrays.stream(arr).sum();
        int l = Arrays.stream(arr)
                    .max()
                    .orElseThrow(() -> new RuntimeException("Array is empty"));
                    
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (canPaint(arr, m, k)) h = m - 1;
            else l = m + 1;
        }
        
        return l;
    }
    
    private boolean canPaint(int[] arr, int time, int k) {
        int paintersUsed = 1;
        int boardLen = 0;
        
        for (int len: arr) {
            if (boardLen + len > time) {
                paintersUsed += 1;
                boardLen = len;
            } else {
                boardLen += len;
            }
        }
        
        if (paintersUsed > k) return false;
        
        return true;
    }
}
