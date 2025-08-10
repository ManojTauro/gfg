class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    private static int mergeSort(int[] a, int l, int h) {
        int count = 0;
        
        if (l >= h) return count;
        
        int mid = (l + h) / 2;
        count += mergeSort(a, l, mid);
        count += mergeSort(a, mid + 1, h);
        count += merge(a, l, mid, h);
        
        return count;
    }
    
    private static int merge(int[] a, int l, int m, int h) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = l;
        int right = m + 1;
        
        int count = 0;
        
        while (left <= m && right <= h) {
            if (a[left] <= a[right]) {
                list.add(a[left]);
                left++;
            } else {
                list.add(a[right]);
                count += m - left + 1;
                right++;
            }
        }
        
        while (left <= m) {
            list.add(a[left]);
            left++;
        }
        
        while (right <= h) {
            list.add(a[right]);
            right++;
        }
        
        for (int i = l; i <= h; i++) {
            a[i] = list.get(i - l);
        }
        
        return count;
    }
}