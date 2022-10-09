class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int lastNegative = 1;
        int curr = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                lastNegative = 1;
                curr = 1;
                ans = Integer.max(nums[i], ans);
            }
            else{
                curr *= nums[i];
                if(curr < 0){
                    if(lastNegative == 1){
                        lastNegative = curr;
                    }
                    else{
                        ans = Integer.max(curr/lastNegative, ans);
                    }
                }
                ans = Integer.max(curr, ans);
            }
        }
        return ans;
    }
}