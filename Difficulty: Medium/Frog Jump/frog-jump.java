class Solution {
    int minCost(int[] height) {
        // code here
        int len = height.length;
        int[] memo = new int[len];
        
        Arrays.fill(memo, -1);
        
        return f(len - 1, height, memo);
    }
    
    private int f(int ind, int[] height, int[] memo) {
        if (ind == 0) return 0;
        
        if (memo[ind] != -1) return memo[ind];
        
        int oneJumpCost = f(ind - 1, height, memo) + Math.abs(height[ind] - height[ind - 1]);
        int twoJumpCost = Integer.MAX_VALUE;
        
        if (ind > 1) twoJumpCost = f(ind - 2, height, memo) + Math.abs(height[ind] - height[ind - 2]);
        
        return memo[ind] = Math.min(oneJumpCost, twoJumpCost);
    }
}