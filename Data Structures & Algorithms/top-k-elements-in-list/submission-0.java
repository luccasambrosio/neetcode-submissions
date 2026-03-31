class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for(int key : map.keySet()){
            queue.add(key);
            if(queue.size() > k){
                queue.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = queue.poll();
        }
        return result;
    }
}
