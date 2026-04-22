class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] currentInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(currentInterval);

        for(int[] nextInterval : intervals){
            int currentEnd = currentInterval[1];
            int nextBegin = nextInterval[0], nextEnd = nextInterval[1];
            if(nextBegin <= currentEnd){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }else{
                currentInterval = nextInterval;
                res.add(currentInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
