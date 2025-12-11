class Solution {
    public ArrayList<String> binstr(int n) {
        char[] s = new char[n];
        ArrayList<String> res = new ArrayList<>();
        
        helper(s, 0, res);
        
        return res;
    }
    
    private void helper(char[] s, int index, ArrayList<String> res) {
        if (index == s.length) {
            res.add(new String(s));
            return;
        }
        
        s[index] = '0';
        helper(s, index + 1, res);
        
        s[index] = '1';
        helper(s, index + 1, res);
    }
}
