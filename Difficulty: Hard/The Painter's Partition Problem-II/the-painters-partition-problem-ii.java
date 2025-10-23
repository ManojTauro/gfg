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
            boardLen = boardLen + len;
            
            if (boardLen > time) {
                paintersUsed += 1;
                boardLen = len;
            }
        }
        
        return paintersUsed <= k;
    }
}
