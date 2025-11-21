class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
            
            if (minHeap.size() == k + 1) {
                arr[j] = minHeap.poll();
                j++;
            }
        }
        
        while (!minHeap.isEmpty()) arr[j++] = minHeap.poll();
    }
}
