// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        int ans = -1;
        
        while (l <= h) {
            int mid = (l + h) / 2;
            
            if (arr[mid] >= k) {
                ans = mid;
                h = mid - 1;
            } else l = mid + 1;
        }
        
        return ans;
        
    }
}
