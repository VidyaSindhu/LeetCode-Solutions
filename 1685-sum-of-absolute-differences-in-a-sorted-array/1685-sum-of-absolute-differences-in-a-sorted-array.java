class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1] + nums[i];
        
        int[] res = new int[n];
        res[0] = prefix[n-1] - n * nums[0];
        for(int i = 1; i < n; i++){
            res[i] = (i * nums[i] - prefix[i-1]) + (prefix[n-1] - prefix[i-1] - (n-i) * nums[i]);
        }
        
        return res;
    }
}