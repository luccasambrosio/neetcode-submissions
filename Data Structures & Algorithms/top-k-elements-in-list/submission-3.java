class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = (List<Integer>[]) new ArrayList[nums.length+1];

        for(int n : nums){
            count.merge(n, 1, Integer::sum);
        }

        count.forEach((key, value) -> {
            if (freq[value] == null) {
                freq[value] = new ArrayList<>();
            }
            freq[value].add(key);
        });

        int[] res = new int[k];
        k--;
        for(int i = freq.length - 1; i >= 0; i--){
            if(freq[i] != null){
                for(int f : freq[i]){
                    if(k < 0) return res;
                    res[k] = f;
                    k--;
                }
            }
        }
        return res;
    }
}
