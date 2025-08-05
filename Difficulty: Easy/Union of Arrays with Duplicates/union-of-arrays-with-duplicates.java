class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        int len1 = a.length;
        int len2 = b.length;
        
        ArrayList<Integer> res = new ArrayList<>();
        int k = 0;
        
        for (int i = 0; i < len1; i++) {
            if (!set.contains(a[i])) {
                set.add(a[i]);
                res.add(a[i]);
            }
        }
        
        for (int i = 0; i < len2; i++) {
            if (!set.contains(b[i])) {
                set.add(b[i]);
                res.add(b[i]);
            }
        }
        
        return res;
        
    }
}