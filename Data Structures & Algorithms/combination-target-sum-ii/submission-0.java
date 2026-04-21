class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, res, target, new ArrayList<>(), 0, 0);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, int target, List<Integer> cur, int i, int total){
        if(total == target){
            res.add(new ArrayList(cur));
            return;
        }

        if(i >= candidates.length || total > target) return;

        cur.add(candidates[i]);
        dfs(candidates, res, target, cur, i + 1, total + candidates[i]);

        while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        cur.remove(cur.size() - 1);
        dfs(candidates, res, target, cur, i + 1, total);
    }
}
