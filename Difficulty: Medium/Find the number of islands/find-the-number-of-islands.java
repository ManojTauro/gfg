//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    int[][] dirs = {
        {-1, 0} , {1, 0}, {0, -1}, {0, 1},
        {-1, -1}, {1, -1}, {-1, 1}, {1, 1}
    };
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];

        int island = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    island++;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return island;
    }
    
    private void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;

        for (int[] dir: dirs) {
            int ni = dir[0] + i;
            int nj = dir[1] + j;

            if (ni >=0 && ni < grid.length 
                && nj >= 0 && nj < grid[0].length
                && !vis[ni][nj] && grid[ni][nj] == '1') {
                    dfs(ni, nj, grid, vis);
                }
        }
    }
    
}