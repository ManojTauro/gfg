//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        int l = lb(arr, target);
        int u = ub(arr, target);
        return u - l;
    }
    
    private int lb(int[] arr, int t) {
        int l = 0;
        int h = arr.length - 1;
        int ans = arr.length;
        
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (arr[m] >= t) {
                ans = m;
                h = m - 1;
            } else l = m + 1;
            
        }
        
        return ans;
    }
    
    private int ub(int[] arr, int t) {
        int l = 0;
        int h = arr.length - 1;
        int ans = arr.length;
        
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (arr[m] > t) {
                ans = m;
                h = m - 1;
            } else l = m + 1;
            
        }
        
        return ans;
    }
}
