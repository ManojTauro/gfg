class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    static int mergeSort(int[] arr, int l, int h) {
        int count = 0;
        
        if (l >= h) return count;
        
        int m = (l + h) / 2;
        
        count += mergeSort(arr, l, m);
        count += mergeSort(arr, m + 1, h);
        count +=merge(arr, l, m, h);
        
        return count;
    }
    
    static int merge(int[] arr, int l, int m, int h) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = l;
        int right = m + 1;
        
        int count = 0;
        
        while (left <= m && right <= h) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                count += m - left + 1;
                right++;
            }
        }
        
        while (left <= m) {
            list.add(arr[left]);
            left++;
        }
        
        while (right <= h) {
            list.add(arr[right]);
            right++;
        }
        
        for (int i = l; i <= h; i++) {
            arr[i] = list.get(i - l);
        }
        
        return count;
    }
}