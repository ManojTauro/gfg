// User function Template for Java

class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        int[][] memo = new int[N][K + 1];
        for (int[] m: memo)
            Arrays.fill(m, -1);
        
        return helper(0, arr, 0, K, memo);
    }
    private static boolean helper(int index, int[] arr, int sum, int K, int[][] memo) {
        if (sum == K) return true;
        
        if (index == arr.length || sum > K) return false;
        
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        
        boolean result = helper(index + 1, arr, sum + arr[index], K, memo) || helper(index + 1, arr, sum, K, memo);
        
        memo[index][sum] = result ? 1 : 0;
        
        return result;
    }
}
