class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Float> stack = new ArrayDeque<>();

        for(int i = 0; i < length; i++){
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        for(int i = 0; i < length/2; i++){
            int tmp = position[i];
            position[i] = position[length - 1 - i];
            position[length - 1 - i] = tmp;
        }

        for(int p : position){
            Float time = (float) (target - p) / map.get(p);
            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }
}
