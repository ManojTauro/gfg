class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int len = arr.length;
        int[][] memo = new int[len][sum + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        
        return solve(len - 1, sum, arr, memo) == 1;
    }
    
    private static int solve(int ind, int target, int[] arr, int[][] memo) {
        if (target == 0) return 1;
        
        if (ind == 0) {
            if (arr[0] == target) return 1;
            return 0;
        }
        
        if (memo[ind][target] != -1) return memo[ind][target];
        
        int take = 0;
        if (arr[ind] <= target) take = solve(ind - 1, target - arr[ind], arr, memo);
        
        int notTake = solve(ind - 1, target, arr, memo);
        
        if (take == 1 || notTake == 1) memo[ind][target] = 1;
        else memo[ind][target] = 0;
        
        return memo[ind][target];
    }
}