class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length-1;
        int ans = nums[0] + nums[1] + nums[n];        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                if(currSum == target) return currSum;
                else if(currSum < target){
                    left++;
                }
                else{
                    right--;
                }
                if(Math.abs(ans - target) > Math.abs(currSum - target)){
                    ans = currSum;
                }
            }
        }
        
        return ans;
    }
}