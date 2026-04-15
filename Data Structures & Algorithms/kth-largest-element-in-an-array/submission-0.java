class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return (!minHeap.isEmpty()) ? minHeap.poll() : 0;
    }
}
