class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for(int n : nums){
            add(n);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
}
