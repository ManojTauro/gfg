// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        
        int ans = 0;
        
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            int rem = prefixSum - k;
            
            if (map.containsKey(rem)) {
                ans = Math.max(ans, i - map.get(rem));
            }
            
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);    
        }   
        
        return ans;
        
    }
}
