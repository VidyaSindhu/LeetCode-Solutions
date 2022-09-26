class Solution {
    public int longestSubarray(int[] nums) {
        int maxSetBits = 0, num = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            // int setBits = countSetBits(nums[i]);
            // System.out.println(setBits);
            if(nums[i] > num){
                // maxSetBits = setBits;
                num = nums[i];
            }
        }
        
        int ans = 0, left = -1, right = 0;
        while(right < n){
            if(nums[right] != num){
                left = -1;
            }
            else{
                if(left == -1){
                    left = right;
                }
                ans = Integer.max(ans, right - left + 1);
            }
            right++;
        }
        
        return ans;
    }
    
    int countSetBits(int num){
        int count = 0;
        for(int i = 32; i >= 0; i--){
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}