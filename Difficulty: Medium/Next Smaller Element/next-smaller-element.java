class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && 
                    nums[i] <= st.peek()) st.poll();

            if (!st.isEmpty()) ans.set(i, st.peek());

            st.push(nums[i]);
        }

        return ans;
        
    }
}