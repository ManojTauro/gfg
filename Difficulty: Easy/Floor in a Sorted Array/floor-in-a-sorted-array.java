
class Solution {

    // this will only work if all the elements are unique
    static int findFloor(int[] arr, int k) {
    //     int l = 0;
    //     int h = arr.length - 1;
    //     int ans = arr.length;
        
    //     while (l <= h) {
    //         int mid = (l + h) / 2;
            
    //         if (arr[mid] >= k) {
    //             ans = mid;
    //             h = mid - 1;
    //         } else l = mid + 1;
    //     }
        
    //     if (ans == arr.length) {
    //       return arr.length - 1;  // Last element is largest ≤ k
    //   }
    //   return arr[ans] == k ? ans : ans - 1;
        
        return findFloorV2(arr, k);
    }
    
    // exactly lower bound
    static int findCeil(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        int ans = arr.length;
        
        while (l <= h) {
            int mid = (l + h) / 2;
            
            if (arr[mid] >= k) {
                ans = mid;
                h = mid - 1;
            } else l = mid + 1;
        }
        
        return ans;
    }
    
    static int findFloorV2(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        int ans = -1;
        
        while (l <= h) {
            int mid = (l + h) / 2;
            
            if (arr[mid] > k) {
                h = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        };
        
        return ans;
    }
}


