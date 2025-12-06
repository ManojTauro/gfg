class Solution {
    public static int countSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int ans = 0;

        int ws = 0; // windowStart
        for (int wr = 0; wr < len; wr++) {
            char c = s.charAt(wr);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() == 3) {
                ans += len - wr;

                char wsChar = s.charAt(ws);
                map.put(wsChar, map.get(wsChar) - 1);
                
                ws++;

                if (map.get(wsChar) == 0) map.remove(wsChar);
            }
        }

        return ans;
        
    }
}
