class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == -1) continue;
            int tmp = nums[i];
            nums[i] = -1;
            ans = Integer.max(ans, dfs(nums, tmp, 0));
        }
        
        return ans;
    }
    
    int dfs(int[] nums, int i, int depth){
        if(i == -1) return depth;
        int tmp = nums[i];
        nums[i] = -1;
        return dfs(nums, tmp, depth+1);
    }
}