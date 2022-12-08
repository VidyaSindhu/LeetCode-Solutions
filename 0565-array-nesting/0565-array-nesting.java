class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            ans = Integer.max(ans, dfs(nums, nums[i], nums[i], 0, visited));
        }
        
        return ans;
    }
    
    int dfs(int[] nums, int i, int p, int depth, boolean[] visited){
        if(nums[i] == p) return depth+1;
        visited[i] = true;
        return dfs(nums, nums[i], p, depth+1, visited);
    }
}