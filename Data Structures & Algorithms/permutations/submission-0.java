class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> cur){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            cur.add(nums[i]);
            used[i] = true;
            dfs(res, nums, used, cur);

            cur.remove(cur.size() - 1);
            used[i] = false;
        }


    }
}
