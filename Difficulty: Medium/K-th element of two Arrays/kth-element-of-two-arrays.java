//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int l = 0;
        int r = 0;
        int n1 = a.length;
        int n2 = b.length;
        int cnt = 0;
        
        while (l < n1 && r < n2) {
            if (a[l] <= b[r]) {
                cnt++;
                if (cnt == k) return a[l];
                
                l++;
            } else {
                cnt++;
                if (cnt == k) return b[r];
                
                r++;
            }
        }
        
        while (l < n1) {
            cnt++;
           if (cnt == k) return a[l];
            
            l++; 
        }
        
        while (r < n2) {
            cnt++;
           if (cnt == k) return b[r];
            
            r++;
        }
        
        return 0;
    }
}