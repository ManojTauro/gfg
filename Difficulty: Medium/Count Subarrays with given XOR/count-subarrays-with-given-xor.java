class Solution {
    public long subarrayXor(int nums[], int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum ^= nums[i];

            int rem = prefixSum ^ k;

            count += map.getOrDefault(rem, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}