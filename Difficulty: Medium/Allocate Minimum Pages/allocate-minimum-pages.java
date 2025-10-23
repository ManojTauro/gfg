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
            
            if (canAllocate(arr, m, k)) high = m - 1;
            else low = m + 1;
        }
        
        return low;
    }
    
    private boolean canAllocate(int[] arr, int minPages, int k) {
        int studentCount = 1;
        int pages = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            pages += arr[i];
            
            if (pages > minPages) {
                studentCount++;
                pages = arr[i];
            }
        }
        
        if (studentCount <= k) return true;
        
        return false;
    }
}