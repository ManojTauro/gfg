// User function Template for Java

class Solution {
    private String getString(int i, int j, int startRow, int startCol) {
        return Integer.toString(i - startRow) +" "+Integer.toString(j - startCol);    
    }
    
    private void dfs(int i, int j,
        int[][] grid, 
        boolean[][] vis, 
        int startRow, 
        int startCol,
        List<String> coordinates) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        vis[i][j] = true;
        
        coordinates.add(getString(i, j, startRow, startCol));
        
        for (int[] dir: dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !vis[ni][nj] && grid[ni][nj] == 1) {
                dfs(ni, nj, grid, vis, startRow, startCol, coordinates);
            }
        }
    }
    
    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Set<List<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    List<String> coordinates = new ArrayList<>();
                    dfs(i, j, grid, vis, i, j, coordinates);
                    set.add(coordinates);
                }
            }
        }
        
        return set.size();
    }
}
