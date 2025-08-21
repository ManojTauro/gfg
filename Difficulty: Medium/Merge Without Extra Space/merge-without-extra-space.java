class Solution {
    public void mergeArrays(int a[], int b[]) {
        int len1 = a.length;
        int len2 = b.length;
        
        int left = a.length - 1;
        int right = 0;
        
        while (left >= 0 && right < len2) {
            if (a[left] > b[right]) {
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            } else break;
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        
    }
}
