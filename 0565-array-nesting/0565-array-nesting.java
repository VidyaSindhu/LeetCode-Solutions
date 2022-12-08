class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        // boolean[] visited = new boolean[n];
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == -1) continue;
            int tmp = nums[i];
            nums[i] = -1;
            ans = Integer.max(ans, dfs(nums, tmp, nums[i], 0));
        }
        
        return ans;
    }
    
    int dfs(int[] nums, int i, int p, int depth){
        if(i == -1) return depth;
        if(nums[i] == -1) return depth+1;
        int tmp = nums[i];
        nums[i] = -1;
        return dfs(nums, tmp, p, depth+1);
    }
}