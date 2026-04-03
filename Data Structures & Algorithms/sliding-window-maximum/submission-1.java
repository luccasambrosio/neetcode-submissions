class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        for(int r = 0; r < nums.length; r++){
            maxHeap.add(new int[] {nums[r], r});

            if(r >= k-1){

                while(maxHeap.peek()[1] <= (r-k)){
                    maxHeap.poll();
                }

                result[count] = maxHeap.peek()[0];
                count++;
            }
        }
        return result;
    }
}
