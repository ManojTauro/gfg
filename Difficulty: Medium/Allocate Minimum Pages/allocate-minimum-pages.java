class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int len = arr.length;
        
        if (k > len) return -1;
        
        // max pages can be held by a student
        int low = Arrays.stream(arr)
            .max()
            .orElseThrow(() -> new RuntimeException("Array is empty"));;
        
        // 1 student can be assigned with all the books/pages
        int high = Arrays.stream(arr).sum();
        
        while (low <= high) {
            int m = (low + high) / 2;
            
            boolean isPossible = canDistribute(arr, m, k);
            // isPossible = true means, books can be distributed to
            // more students than allowed, so we need to increase
            // pages
            if (isPossible) high = m - 1;
            else low = m + 1;
        }
        
        return low;
    }
    
    private boolean canDistribute(int[]arr, int maxPages, int k) {
        int pageCount = 0;
        int students = 1;
        
        for (int num: arr) {
            if (pageCount + num <= maxPages) {
                pageCount += num;
            } else {
                students++;
                pageCount = num;
            }
        }
        
        if (students <= k) return true;
        
        return false;
    }
}