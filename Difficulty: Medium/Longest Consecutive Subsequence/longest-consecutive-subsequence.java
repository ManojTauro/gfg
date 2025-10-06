class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num: arr) set.add(num);
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            if (set.contains(num - 1)) continue;
            
            int seqLength = 0;
            while (set.contains(num)) {
                seqLength++;
                num++;
            }
            
            maxLen = Math.max(maxLen, seqLength);
        }
        
        return maxLen;
        
    }
}