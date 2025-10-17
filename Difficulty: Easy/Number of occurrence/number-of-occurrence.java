class Solution {
    int countFreq(int[] nums, int t) {
        int l = lowerBound(nums, t);
        
        if (l == -1) return 0;

        int r = ub(nums, t);

        return r - l + 1;
        
    }
    
    private int lowerBound(int[] nums, int t) {
        int l = 0;
        int h = nums.length - 1;
        int ans = nums.length;

        while (l <= h) {
            int m = (l + h) / 2;

            if (nums[m] >= t) {
                ans = m;
                h = m - 1;
            } else l = m + 1;
        }

        if (ans < nums.length && nums[ans] == t) return ans;

        return -1;
    }

    private int ub(int[] nums, int t) {
        int l = 0;
        int h = nums.length - 1;
        int ans = nums.length;

        while (l <= h) {
            int m = (l + h) / 2;

            if (nums[m] > t) {
                ans = m;
                h = m - 1;
            } else l = m + 1;
        }

        return ans - 1;
    }
}
