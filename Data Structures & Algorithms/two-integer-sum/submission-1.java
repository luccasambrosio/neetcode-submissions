class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){

            int comp = target - nums[i];
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(comp, i);
            }

        }

        return new int[]{};
    }
}
