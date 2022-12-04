class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        long[] prefix = new long[n];
        
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1] + nums[i];
        
        long ans = Long.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < n; i++){
            long left = prefix[i]/(i+1);
            long right;
            if(i == n-1){
                right = 0;
            }
            else{
                right = (prefix[n-1]-prefix[i])/(n-i-1);
            }
            if(ans > Math.abs(right-left)){
                ans = Math.abs(right-left);
                index = i;
            }
        }
        return index;
    }
}