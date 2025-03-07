//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int l = 0, h = arr.size() - 1;
        int[] nums = new int[arr.size()];
        
        for (int i = 0; i < arr.size(); i++) nums[i] = arr.get(i);
        int min = Integer.MAX_VALUE;
        int index = -1;

        while (l <= h) {
            int m = (l + h) / 2;

            if (nums[l] <= nums[m]) {
                if (nums[l] < min) {
                    min = nums[l];
                    index = l;
                }
                l = m + 1;
            } else if (nums[m] <= nums[h]) {
                if (nums[m] < min) {
                    min = nums[m];
                    index = m;
                }
                h = m - 1;
            }
        }

        return index;
    }
}