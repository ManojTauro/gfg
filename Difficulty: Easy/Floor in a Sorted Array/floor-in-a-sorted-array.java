
class Solution {

    static int findFloor(int[] arr, int k) {
        // int l = 0;
        // int h = arr.length - 1;
        // int ans = arr.length;
        
        // while (l <= h) {
        //     int mid = (l + h) / 2;
            
        //     if (arr[mid] >= k) {
        //         ans = mid;
        //         h = mid - 1;
        //     } else l = mid + 1;
        // }
        
        // return arr[ans] == k ? ans : ans - 1;
        
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
            
            if (arr[mid] <= k) {
                ans = mid;
                l = mid + 1;
            } else h = mid - 1;
        }
        
        return ans;
    }
}


