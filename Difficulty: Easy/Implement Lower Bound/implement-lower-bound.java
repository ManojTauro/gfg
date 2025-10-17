class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int lowerBoundIndex = arr.length;
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] >= target) {
                lowerBoundIndex = mid;
                high = mid - 1;
            } else low = mid + 1;
         }
         
        return lowerBoundIndex;
    }
}
