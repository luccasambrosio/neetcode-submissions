class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, target, 0, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int target, int i, List<Integer> cur, int total){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(i >= nums.length || total > target){
            return;
        }

        cur.add(nums[i]);
        dfs(res, nums, target, i, cur, total + nums[i]);
        cur.remove(cur.size() - 1);
        dfs(res, nums, target, i +1, cur, total);
    }
}
