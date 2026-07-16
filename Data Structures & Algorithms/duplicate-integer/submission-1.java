class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet set = new HashSet<>();

        for(int n : nums){
            if(!set.add(n)) return true;
        }

        return false;
    }
}