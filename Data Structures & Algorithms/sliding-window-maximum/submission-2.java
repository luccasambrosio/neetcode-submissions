class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int r = 0; r < nums.length; r++){
            
            while(!deque.isEmpty() && deque.peekFirst() < r - k + 1){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[r]){
                deque.pollLast();
            }

            deque.offerLast(r);

            if(r >= k-1){
                result[r-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
