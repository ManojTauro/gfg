// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0, 0, arr, ans);
        
        Collections.sort(ans);
        
        return ans;
        
    }
    
    private void helper(int ind, int sum, int[] arr, ArrayList<Integer> ans) {
        if (ind == arr.length) {
            ans.add(sum);
            return;
        }
        
        helper(ind + 1, sum + arr[ind], arr, ans);
        
        helper(ind + 1, sum, arr, ans);
    }
}