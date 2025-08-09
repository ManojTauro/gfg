

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // int leader = 1;
        int max = arr[arr.length - 1];
        ArrayList<Integer> result = new ArrayList<>();
        result.add(max);
        
        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (arr[i] >= max) {
                // leader++;
                max = arr[i];
                result.add(arr[i]);
            }
        }
        
        Collections.reverse(result);
        
        return result;
    }
}
