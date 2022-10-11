class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(nums[i] > firstMin) return true;
            else if(nums[i] > secondMin){
                firstMin = Integer.min(nums[i], firstMin);
            }
            secondMin = Integer.min(secondMin, nums[i]);
        }
        
        return false;
    }
}