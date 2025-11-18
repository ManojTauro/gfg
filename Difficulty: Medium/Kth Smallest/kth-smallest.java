class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
        
        for (int num: arr) {
            if (maxHeap.size() == k) {
                if (maxHeap.peek() > num) {
                    maxHeap.offer(num);
                    maxHeap.poll();
                }
            } else maxHeap.offer(num);
        }        
        
        return maxHeap.peek();
    }
}
