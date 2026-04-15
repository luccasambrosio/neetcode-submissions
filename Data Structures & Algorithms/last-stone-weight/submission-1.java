class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            maxHeap.add(s);
        }

        while(maxHeap.size() > 1){
            int n1 = maxHeap.poll();
            int n2 = maxHeap.poll();
            maxHeap.add(n1-n2);
        }

        return maxHeap.peek();
    }
}
