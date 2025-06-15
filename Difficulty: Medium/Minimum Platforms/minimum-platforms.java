// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int arrival = 0;
        int departure = 0;
        int count = 0;
        int max = 0;
        
        while (arrival < arr.length) {
            if (arr[arrival] <= dep[departure]) {
                count++;
                arrival++;
            } else {
                count--;
                departure++;
            }
            
            max = Math.max(count, max);
        }
        
        return max;
    }
}
