// User function Template for Java
class Solution {
    int minCost(int[] height) {
        int len = height.length;
        int memo[] = new int[len + 1];
        Arrays.fill(memo, -1);
        
        return f(len - 1, height, memo);
        
    }
    
    int f(int ind, int[] height, int[] memo) {
        if (ind == 0) return 0;
        if (memo[ind] != -1) return memo[ind];
        
        int oneStepCost = f(ind - 1, height, memo) + Math.abs(height[ind] - height[ind - 1]);
        
        int twoStepCost = Integer.MAX_VALUE;
        if (ind > 1)
            twoStepCost = f(ind - 2, height, memo) + Math.abs(height[ind] - height[ind - 2]);
            
        int ans = Math.min(oneStepCost, twoStepCost);
        
        memo[ind] = ans;
        
        return ans;
    }
}