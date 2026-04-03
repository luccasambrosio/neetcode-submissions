class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        for(int r = 0; r < nums.length; r++){
            maxHeap.add(nums[r]);
            if(maxHeap.size() == k){
                result[count] = maxHeap.peek();
                count++;
                maxHeap.remove(nums[r+1-k]);
            }
        }
        return result;
    }
}
