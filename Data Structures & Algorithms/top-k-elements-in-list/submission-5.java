class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<int[]> freq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int n : nums){
            count.merge(n, 1, Integer::sum);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            int frequency = entry.getValue();
            int value = entry.getKey();

            freq.add(new int[]{frequency, value});
            if(freq.size() > k){
                freq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = freq.poll()[1];
        }

        return res;
    }
}
