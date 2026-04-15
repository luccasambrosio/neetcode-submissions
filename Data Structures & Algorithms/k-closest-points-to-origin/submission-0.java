class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        if(points.length == 0) return points;
        record PointDistance(long dist, int[] point){};
        PriorityQueue<PointDistance> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.dist(), a.dist()));

        for(int i = 0; i < points.length; i++){
            int dx = points[i][0];
            int dy = points[i][1];
            long dist = (dx * dx) + (dy * dy);
            PointDistance pd = new PointDistance(dist, points[i]);
            maxHeap.add(pd);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] res = new int[maxHeap.size()][2];
        for(int i = 0; i < res.length; i++){
            res[i] = maxHeap.poll().point();
        }
        return res;
    }
}
