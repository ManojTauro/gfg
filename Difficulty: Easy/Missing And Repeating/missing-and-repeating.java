class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
          long sum = 0, sumSq = 0;

          long expectedSum = (long)n * (n + 1) / 2;
          long expectedSumSq = (long)n * (n + 1) * (2 * n + 1) / 6;

          for (int num : arr) {
              sum += num;
              sumSq += (long)num * num;
          }

          long diff = sum - expectedSum;                    
          long sumRM = (sumSq - expectedSumSq) / diff;

          int repeating = (int)(diff + sumRM) / 2;       
          int missing = (int)(sumRM - diff) / 2;          

          ArrayList<Integer> result = new ArrayList<>();
          result.add(repeating);
          result.add(missing);

          return result;
    }
}
