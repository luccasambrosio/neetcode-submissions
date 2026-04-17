class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = (List<Integer>[]) new ArrayList[nums.length+1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(int n : nums){
            count.merge(n, 1, Integer::sum);
        }

        count.forEach((key, value) -> {
            freq[value].add(key);
        });

        int[] res = new int[k];
        k--;
        for(int i = freq.length - 1; i >= 0; i--){
            for(int f : freq[i]){
                if(k < 0) return res;
                res[k] = f;
                k--;
            }
        }
        return res;
    }
}
