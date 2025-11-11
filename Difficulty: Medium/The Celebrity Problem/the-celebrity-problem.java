class Solution {
    public int celebrity(int mat[][]) {
        // code here
        return bf(mat);
    }
    
    private int bf(int[][] mat) {
        int size = mat.length;
        // maintains if I know someone
        int[] a1 = new int[size];
        
        // maintains if someone know me
        int[] a2 = new int[size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                
                if (mat[i][j] == 1) {
                    a1[i]++;
                    a2[j]++;
                }
            }
        }
        
        for (int i = 0; i < size; i++) {
            if (a1[i] == 0 && a2[i] == size - 1) return i;
        }
        
        return -1;
    }
}