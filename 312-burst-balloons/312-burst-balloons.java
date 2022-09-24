class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = nums[i-1];
        }
        memo = new int[n + 1][n + 1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        
        return solve(arr, 1, n);
    }
    
    int solve(int[] nums, int left, int right){
        if(left > right) return 0;
        if(memo[left][right] != -1){
            return memo[left][right];
        }
        
        int ans = 0;
        for(int i = left; i <= right; i++){
            int temp = nums[left-1] * nums[i] * nums[right+1] + solve(nums, left, i-1) + solve(nums, i+1, right);
            ans = Integer.max(ans, temp);
        }
        
        return memo[left][right] = ans;
        
    }
}