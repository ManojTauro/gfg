class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] arr, int sum) {
        int[][] memo = new int[arr.length][sum + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        
        return solve(arr.length - 1, sum, arr, memo);
        
    }
    
    private static int bottomUp(int[] arr, int sum) {
        int len = arr.length;
        int[][] dp = new int[len][sum + 1];
        
        for (int i = 0; i < len; i++) dp[i][0] = 1;
        
        if (arr[0] <= sum)
            dp[0][arr[0]] = 1;
        
        for (int ind = 1; ind < len; ind++) {
            for (int target = 1; target <= sum; target++) {
                int notTake = dp[ind - 1][target];
                
                int take = 0;
                if (arr[ind] <= target)
                    take = dp[ind - 1][target - arr[ind]];
        
                dp[ind][target] = take + notTake;
            }
        }
        
        return dp[len - 1][sum];
    }
    
    private static int solve(int ind, int target, int[] arr, int[][] memo) {
        if (ind == 0) {
    int ways = 0;
    
    // Option 1: Don't take arr[0]
    if (target == 0) ways++;  // We successfully formed 0 by taking nothing
    
    // Option 2: Take arr[0]  
    if (arr[0] == target) ways++;  // We successfully formed target
    
    return ways;
}

        // if (target == 0) return 1;
        
        if (memo[ind][target] != -1) return memo[ind][target];
        
        int notTake = solve(ind - 1, target, arr, memo);
        int take = 0;
        if (arr[ind] <= target) 
            take = solve(ind - 1, target - arr[ind], arr, memo);
        
        return memo[ind][target] = take + notTake;
    }
}