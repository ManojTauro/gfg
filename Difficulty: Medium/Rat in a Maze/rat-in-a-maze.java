class Solution {
    boolean[][] vis;
    int m;
    int n;
    ArrayList<String> ans = new ArrayList<>();
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        this.m = maze.length;
        this.n = maze[0].length;
        vis = new boolean[m][n];
        
        helper(0, 0, maze, new StringBuilder());
        
        return ans;
        
    }
    
    private void helper(int i, int j, int[][] maze, StringBuilder s) {
        if (!isValid(maze, i, j)) return;
        
        if (i == m - 1 && j == n - 1) {
            ans.add(s.toString());
            return;
        }
        
        int[][] positions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        char[] dirs = {'D', 'L', 'R', 'U'};
        vis[i][j] = true;
        
        int k = 0;
        for (int[] pos: positions) {
            int ni = pos[0] + i;
            int nj = pos[1] + j;
            
            char dir = dirs[k++];
            s.append(dir+"");
            helper(ni, nj, maze, s);
            s.deleteCharAt(s.length() - 1);
        }

        vis[i][j] = false;
    }
    
    private boolean isValid(int[][] maze, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n && !vis[i][j] && maze[i][j] == 1;
    }
}