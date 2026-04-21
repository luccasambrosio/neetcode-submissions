class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(res, subset, 0, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> subset, int i, int[] nums){
        if(i >= nums.length){
            res.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);

        dfs(res, subset, i + 1, nums);
        subset.remove(subset.size() - 1);
        dfs(res, subset, i + 1, nums);
    }
}
