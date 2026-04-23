class Solution {
    int[] cache1;
    int[] cache2;
    public int rob(int[] nums) {
        int length = nums.length;
        if(length <= 1) return (length == 1) ? nums[0] : 0;
        return Math.max(helper(Arrays.copyOfRange(nums, 0, length-1)), helper(Arrays.copyOfRange(nums, 1, length)));
    }

    public int helper(int[] nums){
        int rob1 = 0, rob2 = 0;

        for(int num : nums){
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp; 
        }

        return rob2;
    }
}
