class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        reverse(nums);
        int ans = 0, right = 0;
        while(right < n){
            int i = right + 1;
            while(i < n && nums[i] == nums[i-1]){
                i++;
            }
            if(i < n){
                ans += i;
            }
            right = i;
        }
        
        return ans;
    }
    
    void reverse(int[] nums){
        int i = 0, j = nums.length-1;
        
        while(i < j){
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
    
}