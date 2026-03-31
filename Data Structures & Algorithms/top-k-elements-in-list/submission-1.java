class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.merge(num, 1, Integer::sum);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        int counter = 0;
        int[] result = new int[k];
        for(int i = buckets.length-1; i >= 0; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    result[counter] = num;
                    counter++;

                    if(counter == k){
                        return result;
                    }
                }
                
            }
        }

        return result;
    }
}
