class Solution {
    public int findMin(int n) {
        // code here
        int[] arr = {10, 5, 2, 1};
        
        int ans = 0;
        while (n != 0) {
            for (int i = 0; i < 4; i++) {
                if (arr[i] <= n) {
                    n -= arr[i];
                    ans++;
                    break;
                }
            }
        }
        
        return ans;
    }
}
