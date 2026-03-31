class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        int[] postNums = new int[nums.length];
        int[] suNums = new int[nums.length];
        suNums[0] = nums[0];
        postNums[postNums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            suNums[i] = nums[i] * suNums[i-1];
        }
        for(int i = nums.length-2; i >= 0; i--){
            postNums[i] = nums[i] *  postNums[i+1];
        }
        nums[0] = postNums[1];
        nums[nums.length-1] = suNums[nums.length-2];
        for(int i = 1; i < nums.length-1; i++){
            nums[i] = suNums[i-1] * postNums[i+1];
        }
        return nums;
    }
}  
