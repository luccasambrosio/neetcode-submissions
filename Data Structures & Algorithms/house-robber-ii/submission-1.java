class Solution {
    int[] cache1;
    int[] cache2;
    public int rob(int[] nums) {
        if(nums.length <= 1) return (nums.length == 1) ? nums[0] : 0;
        int length = nums.length;
        cache1 = new int[length];
        cache2 = new int[length];
        Arrays.fill(cache1, -1);
        Arrays.fill(cache2, -1);

        return Math.max(
            dfs(nums, 0, length - 2, cache1),
            dfs(nums, 1, length - 1, cache2)
        );
    }

    public int dfs(int[] nums, int i, int n, int[] cache){
        if(i > n) return 0;
        if(cache[i] != -1) return cache[i];

        cache[i] = Math.max(dfs(nums, i + 1, n, cache), nums[i] + dfs(nums, i + 2, n, cache));
        return cache[i];
    }
}
