class Solution {
    public int maxArea(int[] heights) {
        int maxContainer = 0;
        int l = 0, r = heights.length -1;
        while(l < r){
            int currentContainer = (r-l) * Math.min(heights[l], heights[r]);
            maxContainer = Math.max(maxContainer, currentContainer);
            
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxContainer;
    }
}
