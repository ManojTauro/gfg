class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        int len = arr.length;
        
        for (int i = 0; i < len; i++)
            ans.add(-1);
        
        for (int i = 0; i < len; i ++) {
            while (!st.isEmpty() && st.peek() >= arr[i])
                st.pop();
                
            if (!st.isEmpty()) ans.set(i, st.peek());

            st.push(arr[i]);
        }
        
        return ans;
    }
}