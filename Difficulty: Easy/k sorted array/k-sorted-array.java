// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        Map<Integer, Integer> positionsMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            positionsMap.put(arr[i], i);
        }
        
        Arrays.sort(arr);
        
        for (int targetPos = 0; targetPos < n; targetPos++) {
            int key = arr[targetPos];
            int originalIndex = positionsMap.get(key);
            
            if (Math.abs(targetPos - originalIndex) > k) return "No";
        }
        
        return "Yes";
    }
}