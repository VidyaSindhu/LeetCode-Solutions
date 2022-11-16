class Solution {
    public int[] secondGreaterElement(int[] nums) {
        Deque<Integer> stack1 = new ArrayDeque();
        Deque<Integer> stack2 = new ArrayDeque();
        Deque<Integer> tmp = new ArrayDeque();
        
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i < n; i++){
            while(!stack2.isEmpty() && nums[stack2.peek()] < nums[i]){
                res[stack2.pop()] = nums[i];
            }
            
            while(!stack1.isEmpty() && nums[stack1.peek()] < nums[i]){
                tmp.push(stack1.pop());
            }
            
            while(!tmp.isEmpty()){
                stack2.push(tmp.pop());
            }
            stack1.push(i);
        }
        
        return res;
    }
}