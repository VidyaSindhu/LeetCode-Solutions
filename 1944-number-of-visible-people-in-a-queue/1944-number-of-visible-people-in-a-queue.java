class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque();
        int n = heights.length;
        int[] res = new int[n];
        
        int count = 0;
        for(int i = n-1; i >= 0; i--){
            count = 0;
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                stack.pop();
                count++;
            }
            if(!stack.isEmpty()) count++;
            res[i] = count;
            stack.push(i);
        }
        
        return res;
    }
}