class Solution {
    int maxLength(int arr[]) {
        // code here
        int prefixSum = 0;
        int maxLength = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            if (map.containsKey(prefixSum))
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            else map.put(prefixSum, i);
        }
        
        return maxLength;
    }
}