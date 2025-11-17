class Solution {
    public int longestKSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int ws = 0;
        int we = 0;
        int n = s.length();
        int ans = -1;
        
        for (we = 0; we < n; we++) {
            char c = s.charAt(we);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            if (map.size() > k) {
                char leftChar = s.charAt(ws);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if (map.get(leftChar) == 0) map.remove(leftChar);
                ws++;
            }
            
            if (map.size() == k) {
                ans = Math.max(ans, we - ws + 1);
            }
        }
        
        return ans;
        
    }
}