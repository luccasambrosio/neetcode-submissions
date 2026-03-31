class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(set.contains(num-1)) continue;

            int currentStreak = 1;
            int currentNum = num;
            while(set.contains(currentNum+1)){
                currentStreak++;
                currentNum++;
            }
            maxLength = Math.max(maxLength, currentStreak);
        }

        return maxLength;
    }
}
