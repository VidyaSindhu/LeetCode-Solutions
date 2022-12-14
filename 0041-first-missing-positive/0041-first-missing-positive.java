class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0) nums[i] = n+1;
        }
        
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]);
            if(index < n+1 && nums[index-1] > 0){
                nums[index-1] = -1 * nums[index-1];
            }
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) return i+1;
        }
        
        return n+1;
    }
}