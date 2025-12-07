class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int len = arr.length;
        
        int arrivalInd = 0;
        int deptInd = 0;
        int platformsRequired = 0;
        int ans = 0;
        
        while (arrivalInd < len) {
            if (arr[arrivalInd] <= dep[deptInd]) {
                arrivalInd++;
                platformsRequired++;
            } else {
                deptInd++;
                platformsRequired--;
            }
            
            ans = Math.max(ans, platformsRequired);
            
        }
        
        return ans;
        
    }
}
