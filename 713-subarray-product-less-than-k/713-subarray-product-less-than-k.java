class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int right = 0, left = 0;
        int prod = 1;
        int ans = 0;
        while(right < nums.length){
            prod *= nums[right];
            while(prod >= k){
                prod /= nums[left++];
            }
            ans += right - left + 1;
            right++;
        }
        
        return ans;
    }
}