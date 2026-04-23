class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            int curArea = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, curArea);

            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxArea;
    }
}
