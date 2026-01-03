// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        int totalDays = arr.length;
        int totalTasks = 3;
        int[][] memo = new int[totalDays][totalTasks + 1];
        
        for (int[] row: memo) Arrays.fill(row, -1);
        
        return solve(totalDays - 1, totalTasks, arr, memo);
    }
    
    private int solve(int day, int prevTask, int[][] arr, int[][] memo) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task == prevTask) continue;
                
                max = Math.max(max, arr[0][task]);   
            }
            
            return max;
        }
        
        if (memo[day][prevTask] != -1) return memo[day][prevTask];
        
        int maxMerits = 0;
        for (int task = 0; task < 3; task++) {
            if (task == prevTask) continue;
            
            int merit = arr[day][task] + solve(day - 1, task, arr, memo);
            maxMerits = Math.max(maxMerits, merit);
        }
        
        return memo[day][prevTask] = maxMerits;
    }
}