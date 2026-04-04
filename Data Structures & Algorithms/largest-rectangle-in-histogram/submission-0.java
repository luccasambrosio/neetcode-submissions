class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int index = stack.pop();
                int height = heights[index];
                int width;
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            int height = heights[index];
            int width;
            if(stack.isEmpty()){
                width = length;
            }else{
                width = length - stack.peek() - 1;
            }
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }
}
