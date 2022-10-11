class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Integer.max(right[i+1], nums[i]);
        }
        
        int leftMin = nums[0];
        for(int i = 1; i < n-1; i++){
            if(nums[i] > leftMin && nums[i] < right[i+1]){
                return true;
            }
            leftMin = Integer.min(leftMin, nums[i]);
        }
        
        return false;
    }
}