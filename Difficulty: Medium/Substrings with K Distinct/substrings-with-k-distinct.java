//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(new Solution().countSubstr(s, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }
    
    int atMostK(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            while (map.size() > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                
                left++;
            }
            
            count += right - left + 1;
            right++;
        }
        
        return count;
    }
}