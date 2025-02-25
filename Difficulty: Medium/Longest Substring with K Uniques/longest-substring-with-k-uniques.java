//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int max = -1;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (map.size() > k) {
                char leftC = s.charAt(left);
                map.put(leftC, map.getOrDefault(leftC, 0) - 1);
                
                if (map.get(leftC) == 0) map.remove(leftC);
                
                left++;
            }
            
            if (map.size() == k) {
                max = Math.max(max, right - left + 1);
            }
            
            right++;
        }
        
        return max;
    }
}