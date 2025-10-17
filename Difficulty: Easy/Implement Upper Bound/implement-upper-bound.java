class Solution {
    int upperBound(int[] arr, int target) {
        int upperBoundIndex = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                upperBoundIndex = mid;
                high = mid - 1;
            } else low = mid + 1;
         }

        return upperBoundIndex;
    }
}