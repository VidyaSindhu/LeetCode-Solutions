class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1){
            return heights[0];
        }
        
        Deque<Integer> stack = new ArrayDeque();
        int maxArea = 0;
        
        for(int i = 0; i < heights.length+1; i++){
            int currentHeight = i == heights.length ? 0 : heights[i];
            
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // int width = i - top;
                
                int area = heights[top] * width;
                
                maxArea = Integer.max(maxArea, area);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}