class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int left = 0;
        int right = 0;
        
        int minLen = Math.min(a.length, b.length);
        ArrayList<Integer> res = new ArrayList<>();
        
        while (left < a.length && right < b.length) {
            if (a[left] == b[right]) {
                if (check(res, a[left])) {
                    res.add(a[left]);
                }
                
                left++;
                right++;
            } else if (a[left] < b[right]) {
                if (check(res, a[left]))
                    res.add(a[left]);
                    
                left++;
            } else {
                if (check(res, b[right]))
                    res.add(b[right]);
                    
                right++;
            }
        }
        
        while (left < a.length) {
            if (check(res, a[left]))
                res.add(a[left]);
                
            left++;
        }
        
        while (right < b.length) {
            if (check(res, b[right]))
                res.add(b[right]);
            
            right++;
        }
        
        return res;
    }
    
    private static boolean check(ArrayList<Integer> res, int num) {
        return res.isEmpty() || res.get(res.size() - 1) != num;
    }
}
