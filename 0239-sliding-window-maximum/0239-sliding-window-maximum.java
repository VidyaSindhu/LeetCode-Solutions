class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        
        int[] res = new int[nums.length-k+1];
        
        Deque<Integer> queue = new LinkedList();
        int left = 0, right = 0, i = 0;
        while(right < nums.length){
            while(!queue.isEmpty() && right - left + 1 > k){
                res[i++] = nums[queue.peekFirst()];
                
                if(nums[queue.peekFirst()] == nums[left]){
                    queue.pollFirst();
                }
                left++;
            }
            
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[right]){
                queue.pollLast();
            }
            queue.offerLast(right);
            right++;
        }
        res[i++] = nums[queue.peekFirst()];
        return res;
    }
}